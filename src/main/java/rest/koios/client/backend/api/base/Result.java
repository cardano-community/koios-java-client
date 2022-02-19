package rest.koios.client.backend.api.base;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Result Object Of type T
 * @param <T> Result Type
 */
@Data
@Builder
@ToString
public class Result<T> {

    boolean successful;
    String response;
    int code;
    T value;
}

