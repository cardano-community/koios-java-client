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
}

