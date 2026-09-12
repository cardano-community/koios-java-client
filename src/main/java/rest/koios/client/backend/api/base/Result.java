package rest.koios.client.backend.api.base;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Result Object Of type T
 * @param <T> Result Type
 */
@Getter
@Builder
@ToString
public class Result<T> {

    boolean successful;
    String response;
    int code;
    T value;

    /**
     * Structured error, when the failing response carried a JSON error body.
     * Null on success, and null when the body was not JSON of that shape.
     */
    KoiosError error;

    /**
     * Whether this result was constructed by the client rather than reported by the server.
     * <p>
     * The client returns a failed result in a few cases where no HTTP error occurred at all - a
     * request rejected by local validation before it was sent, or a 200 response whose body was
     * empty or missing where a single object was expected. Those results still carry a
     * {@code code} so that callers branching on it keep working, but the code was chosen by the
     * client and never came from Koios.
     * <p>
     * False for every result that reflects an actual HTTP response, successful or not. Check this
     * before treating {@code code} as a server status.
     */
    boolean synthetic;
}

