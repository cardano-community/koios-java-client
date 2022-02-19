package rest.koios.client.backend.api.base;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import lombok.Data;
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
import java.time.Duration;
import java.util.Objects;

/**
 * Base Service
 */
@Data
@Slf4j
public class BaseService {

    private final Retrofit retrofit;
    private final Duration timeoutDuration = Duration.ofSeconds(20);
    private final Bucket bucket;
    private final Options emptyOptions = new Options();

    /**
     * Base Service Constructor
     *
     * @param baseUrl Base URL
     */
    public BaseService(String baseUrl) {
        bucket = Bucket.builder().addLimit(Bandwidth.classic(100, Refill.intervally(100, Duration.ofSeconds(10)))).build();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).addConverterFactory(JacksonConverterFactory.create()).build();
    }

    /**
     * processResponse
     *
     * @param response the Response to process
     * @param <T>      Type Of Response
     * @return Result of Response
     */
    protected <T> Result<T> processResponse(Response<T> response) {
        if (response.isSuccessful())
            return (Result<T>) Result.builder().successful(true).response(response.toString()).value(response.body()).code(response.code()).build();
        else
            return (Result<T>) Result.builder().successful(false).response(Objects.requireNonNull(response.errorBody()).toString()).code(response.code()).build();
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
            return (Response<Object>) call.execute();
        } else {
            throw new ApiException("HTTP Error (429) - Too Many Requests.");
        }
    }

    /**
     * Validate Epoch
     *
     * @param epochNo Epoch Number
     * @throws ApiException if an error occurs while attempting to validate epoch
     */
    protected void validateEpoch(Long epochNo) throws ApiException {
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
        if (!hex.matches("^[0-9a-fA-F]+$")) {
            throw new ApiException("Invalid Hexadecimal String Format");
        }
    }
}
