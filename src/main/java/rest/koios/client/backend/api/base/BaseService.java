package rest.koios.client.backend.api.base;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.utils.Bech32Util;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Base Service
 */
@Slf4j
@Getter
public class BaseService {

    private final Retrofit retrofit;
    private final Bucket bucket;
    private int retriesCount = 5;
    private static final int SLEEP_TIME_MILLIS = 2000;

    public BaseService(BaseService baseService) {
        this.retrofit = baseService.getRetrofit();
        this.bucket = baseService.getBucket();
        this.retriesCount = baseService.getRetriesCount();
    }

    /**
     * Base Service Constructor
     *
     * @param baseUrl Base URL
     */
    public BaseService(String baseUrl) {
        bucket = Bucket.builder().addLimit(Bandwidth.simple(100, Duration.ofSeconds(10))).build();
        int readTimeoutSec = getReadTimeoutSec();
        log.info("Set Read Timeout to {} Seconds", readTimeoutSec);
        int connectTimeoutSec = getConnectTimeoutSec();
        log.info("Set Connect Timeout to {} Seconds", connectTimeoutSec);
        boolean logging = Boolean.parseBoolean(System.getenv("KOIOS_JAVA_LIB_LOGGING"));
        OkHttpClient okHttpClient;
        if (logging) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(readTimeoutSec, TimeUnit.SECONDS)
                    .connectTimeout(connectTimeoutSec, TimeUnit.SECONDS)
                    .addInterceptor(interceptor).build();
        } else {
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(readTimeoutSec, TimeUnit.SECONDS)
                    .connectTimeout(connectTimeoutSec, TimeUnit.SECONDS)
                    .build();
        }
        String strRetries = System.getenv("KOIOS_JAVA_LIB_RETRIES_COUNT");
        if (strRetries != null && !strRetries.isEmpty()) {
            retriesCount = Math.max(Integer.parseInt(strRetries), 1);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient).addConverterFactory(JacksonConverterFactory
                .create(objectMapper)).build();
    }

    private int getReadTimeoutSec() {
        int readTimeoutSec = 60;
        String strReadTimeoutSec = System.getenv("KOIOS_JAVA_LIB_READ_TIMEOUT_SEC");
        if (strReadTimeoutSec != null && !strReadTimeoutSec.isEmpty()) {
            readTimeoutSec = Integer.parseInt(strReadTimeoutSec);
        }
        return readTimeoutSec >= 1 ? readTimeoutSec : 60;
    }

    private int getConnectTimeoutSec() {
        int connectTimeoutSec = 60;
        String strReadTimeoutSec = System.getenv("KOIOS_JAVA_LIB_CONNECT_TIMEOUT_SEC");
        if (strReadTimeoutSec != null && !strReadTimeoutSec.isEmpty()) {
            connectTimeoutSec = Integer.parseInt(strReadTimeoutSec);
        }
        return connectTimeoutSec >= 1 ? connectTimeoutSec : 60;
    }

    protected <T> Result<T> processResponseGetOne(Response<List<T>> response) throws IOException {
        if (response.isSuccessful()) {
            if (response.body() != null && !response.body().isEmpty()) {
                return (Result<T>) Result.builder().successful(true).response(response.toString()).value(response.body().get(0)).code(response.code()).build();
            } else if (response.body() != null) {
                return (Result<T>) Result.builder().successful(false).response("Response Body is Empty").code(404).build();
            } else {
                return (Result<T>) Result.builder().successful(false).response("Response Body is Invalid").code(500).build();
            }
        } else {
            return (Result<T>) Result.builder().successful(false).response(Objects.requireNonNull(response.errorBody()).string()).code(response.code()).build();
        }
    }

    protected <T> Result<T> badRequestResult(String responseText) {
        return (Result<T>) Result.builder().successful(false).response(responseText).code(400).build();
    }

    /**
     * processResponse
     *
     * @param response the Response to process
     * @param <T>      Type Of Response
     * @return Result of Response
     * @throws IOException upon null Response Error Body
     */
    protected <T> Result<T> processResponse(Response<T> response) throws IOException {
        if (response.isSuccessful())
            return (Result<T>) Result.builder().successful(true).response(response.toString()).value(response.body()).code(response.code()).build();
        else
            return (Result<T>) Result.builder().successful(false).response(Objects.requireNonNull(response.errorBody()).string()).code(response.code()).build();
    }

    /**
     * getRequest
     *
     * @param call Retrofit2 Call
     * @return Response Object type defined by clazz
     * @throws ApiException if an error occurs while attempting to invoke the API
     * @throws IOException  if an error occurs while attempting to invoke the API
     */
    public Response<Object> execute(Call<?> call) throws ApiException, IOException {
        int tryCount = 1;
        while (tryCount <= retriesCount) {
            if (getBucket().tryConsume(1)) {
                try {
                    Response<Object> response = (Response<Object>) call.clone().execute();
                    if (response.code() == 429) {
                        log.warn("429 Too Many Requests.");
                        tryCount = retry(tryCount);
                    } else if (response.code() == 504) {
                        log.warn(response.message());
                        tryCount = retry(tryCount);
                    } else {
                        return response;
                    }
                } catch (SocketTimeoutException e) {
                    log.warn(e.getMessage());
                    tryCount = retry(tryCount);
                }
            } else {
                throw new ApiException("HTTP Error (429) - Too Many Requests.");
            }
        }
        throw new ApiException("Retry Count Exceeded (" + tryCount + "/" + retriesCount + ").");

    }

    private void sleep(int timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    private int retry(int tryCount) {
        tryCount++;
        if (tryCount < retriesCount) {
            log.info("Retrying in {}s ... (" + tryCount + "/" + retriesCount + ")", SLEEP_TIME_MILLIS * tryCount / 1000);
            sleep(SLEEP_TIME_MILLIS * tryCount);
        }
        return tryCount;
    }

    /**
     * Validate Epoch
     *
     * @param epochNo Epoch Number
     * @throws ApiException if an error occurs while attempting to validate epoch
     */
    protected void validateEpoch(Integer epochNo) throws ApiException {
        if (epochNo == null) {
            throw new ApiException("Null Value for \"epochNo\"");
        }
        if (epochNo < 0) {
            throw new ApiException("Non Positive \"epochNo\" Value");
        }
    }

    /**
     * Validate Bech32 Format
     *
     * @param bech32 string to validate
     * @throws ApiException if an error occurs while attempting to validate bech32 string
     */
    protected void validateBech32(String bech32) throws ApiException {
        if (!Bech32Util.isValid(bech32)) {
            throw new ApiException("Invalid Bech32 Format");
        }
    }

    /**
     * Validate Hex Format
     *
     * @param hex string to validate
     * @throws ApiException if an error occurs while attempting to validate hex string
     */
    protected void validateHexFormat(String hex) throws ApiException {
        if (!hex.isEmpty() && !hex.matches("^[\\da-fA-F]+$")) {
            throw new ApiException("Invalid Hexadecimal String Format");
        }
    }

    protected Map<String, String> optionsToParamMap(Options options) {
        Map<String, String> paramsMap = Collections.emptyMap();
        if (options != null && !options.getOptionList().isEmpty()) {
            paramsMap = options.toMap();
        }
        return paramsMap;
    }
}
