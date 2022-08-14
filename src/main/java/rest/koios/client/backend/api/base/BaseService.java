package rest.koios.client.backend.api.base;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
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
        bucket = Bucket.builder().addLimit(Bandwidth.classic(100, Refill.intervally(100, Duration.ofSeconds(10)))).build();
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
            } else {
                return (Result<T>) Result.builder().successful(false).response("Response Body is Invalid").code(500).build();
            }
        } else {
            return (Result<T>) Result.builder().successful(false).response(Objects.requireNonNull(response.errorBody()).string()).code(response.code()).build();
        }
    }

    /**
     * processResponse
     *
     * @param response the Response to process
     * @param <T>      Type Of Response
     * @return Result of Response
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
        if (getBucket().tryConsume(1)) {
            int tryCount = 1;
            while (tryCount <= retriesCount) {
                try {
                    Response<Object> response = (Response<Object>) call.clone().execute();
                    if (response.code() != 504) {
                        return response;
                    } else {
                        log.warn(response.message());
                        tryCount = retry(tryCount);
                    }
                } catch (SocketTimeoutException e) {
                    log.warn(e.getMessage());
                    tryCount = retry(tryCount);
                }
            }
            throw new ApiException("Retry Count Exceeded.");
        } else {
            throw new ApiException("HTTP Error (429) - Too Many Requests.");
        }
    }

    private int retry(int tryCount) {
        tryCount++;
        if (tryCount < retriesCount) {
            log.info("Retrying... ("+tryCount+"/"+ retriesCount +")");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
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
        if (!hex.matches("^[\\da-fA-F]+$")) {
            throw new ApiException("Invalid Hexadecimal String Format");
        }
    }

    protected Map<String, String> optionsToParamMap(Options options) {
        Map<String, String> paramsMap = Collections.emptyMap();
        if (options != null && !options.getOptions().isEmpty()) {
            paramsMap = options.toMap();
        }
        return paramsMap;
    }
}
