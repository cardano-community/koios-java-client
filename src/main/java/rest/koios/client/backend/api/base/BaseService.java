package rest.koios.client.backend.api.base;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.api.base.interceptor.GzipInterceptor;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.utils.Bech32Util;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.net.SocketTimeoutException;
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
    private int retriesCount = 5;
    private static final int SLEEP_TIME_MILLIS = 2000;
    private boolean retryOnTimeout = true;
    private final String apiToken;
    private int readTimeoutSec = 300;
    private int connectTimeoutSec = 300;
    private boolean gzipCompression = true;

    /**
     * Base Service Constructor
     *
     * @param baseUrl Base URL
     */
    public BaseService(String baseUrl) {
        this(baseUrl, null);
    }

    /**
     * Base Service Constructor
     *
     * @param baseUrl Base URL
     * @param apiToken Authorization Bearer JWT Token
     */
    public BaseService(String baseUrl, String apiToken) {
        this.apiToken = apiToken;

        String strReadTimeoutSec = System.getenv("KOIOS_JAVA_LIB_READ_TIMEOUT_SEC");
        if (strReadTimeoutSec != null && !strReadTimeoutSec.isEmpty()) {
            int readTimeoutSec = Integer.parseInt(strReadTimeoutSec);
            if (readTimeoutSec >= 1) {
                this.readTimeoutSec = readTimeoutSec;
            }
        }

        String strConnectTimeoutSec = System.getenv("KOIOS_JAVA_LIB_CONNECT_TIMEOUT_SEC");
        if (strConnectTimeoutSec != null && !strConnectTimeoutSec.isEmpty()) {
            int connectTimeoutSec = Integer.parseInt(strConnectTimeoutSec);
            if (connectTimeoutSec >= 1) {
                this.connectTimeoutSec = connectTimeoutSec;
            }
        }

        boolean logging = Boolean.parseBoolean(System.getenv("KOIOS_JAVA_LIB_LOGGING"));
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.readTimeout(readTimeoutSec, TimeUnit.SECONDS)
                .connectTimeout(connectTimeoutSec, TimeUnit.SECONDS);
        if (logging) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(interceptor).build();
        }
        if (apiToken != null && !apiToken.isEmpty()) {
            okHttpClientBuilder.addInterceptor(new Interceptor() {
                @NotNull
                @Override
                public okhttp3.Response intercept(@NotNull Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Authorization", "Bearer "+apiToken)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });
        }

        if (System.getenv("KOIOS_JAVA_LIB_GZIP_COMPRESSION") != null) {
            gzipCompression = Boolean.parseBoolean(System.getenv("KOIOS_JAVA_LIB_GZIP_COMPRESSION"));
        }
        if (gzipCompression) {
            okHttpClientBuilder.addInterceptor(new GzipInterceptor());
        }

        String strRetries = System.getenv("KOIOS_JAVA_LIB_RETRIES_COUNT");
        if (strRetries != null && !strRetries.isEmpty()) {
            retriesCount = Math.max(Integer.parseInt(strRetries), 1);
        }
        String retryOnTimeoutEnv = System.getenv("KOIOS_JAVA_LIB_RETRY_ON_TIMEOUT");
        if (retryOnTimeoutEnv != null && !Boolean.parseBoolean(retryOnTimeoutEnv)) {
            retryOnTimeout = false;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(okHttpClientBuilder.build()).addConverterFactory(JacksonConverterFactory
                .create(objectMapper)).build();
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
                if (retryOnTimeout) {
                    tryCount = retry(tryCount);
                } else {
                    throw new ApiException("Timeout Error");
                }
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
