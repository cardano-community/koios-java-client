package rest.koios.client.backend.api.base;

import rest.koios.client.backend.api.base.exception.ApiException;
import rest.koios.client.backend.factory.OperationType;
import rest.koios.client.backend.factory.options.Option;
import rest.koios.client.backend.factory.options.Options;
import rest.koios.client.utils.Bech32Util;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Collections;
import java.util.Locale;

/**
 * Base Service
 */
@Data
public class BaseService {

    private final WebClient webClient;
    private final String customUrlSuffix;
    private final Duration timeoutDuration = Duration.ofSeconds(20);
    private final Bucket bucket;
    private final Options emptyOptions = new Options();
    private final MultiValueMap<String, String> emptyMultiValueMap = new LinkedMultiValueMap<>();

    /**
     * Base Service Constructor
     *
     * @param operationType operationType
     * @param webClient     webClient
     */
    public BaseService(OperationType operationType, WebClient webClient) {
        this.webClient = webClient;
        if (operationType == OperationType.CUSTOM_RPC) {
            customUrlSuffix = "/rpc";
        } else {
            customUrlSuffix = "";
        }
        bucket = Bucket.builder().addLimit(Bandwidth.classic(100, Refill.intervally(100, Duration.ofSeconds(10)))).build();
    }

    /**
     * sendGetRequest
     *
     * @param uri     uri
     * @param options options
     * @param clazz   return object class
     * @return Response Object type defined by clazz
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    public Object sendGetRequest(String uri, Options options, Class<?> clazz) throws ApiException {
        return sendGetRequest(uri, emptyMultiValueMap, options, clazz);
    }

    /**
     * sendGetRequest
     *
     * @param uri           uri
     * @param requestParams request parameters
     * @param options       options
     * @param clazz         return object class
     * @return Response Object type defined by clazz
     * @throws ApiException if an error occurs while attempting to invoke the API
     */
    public Object sendGetRequest(String uri, MultiValueMap<String, String> requestParams, Options options, Class<?> clazz) throws ApiException {
        if (getBucket().tryConsume(1)) {
            if (options != null) {
                for (Option option : options.getOptions()) {
                    requestParams.put(option.getOptionType().name().toLowerCase(Locale.ROOT), Collections.singletonList(option.getValue()));
                }
            }
            return getWebClient().get()
                    .uri(uriBuilder -> uriBuilder.path(getCustomUrlSuffix() + uri).queryParams(requestParams).build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(clazz)
                    .timeout(getTimeoutDuration())
                    .block();
        } else {
            throw new ApiException("Too Many Requests.", HttpStatus.TOO_MANY_REQUESTS);
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
            throw new ApiException("Null Value for \"epochNo\"", HttpStatus.BAD_REQUEST);
        }
        if (epochNo < 0) {
            throw new ApiException("Non Positive \"epochNo\" Value", HttpStatus.BAD_REQUEST);
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
            throw new ApiException("Invalid Bech32 Format", HttpStatus.BAD_REQUEST);
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
            throw new ApiException("Invalid Hexadecimal String Format", HttpStatus.BAD_REQUEST);
        }
    }
}
