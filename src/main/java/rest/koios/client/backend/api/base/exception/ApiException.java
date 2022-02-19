package rest.koios.client.backend.api.base.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * ApiException
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ApiException extends Exception {

    /**
     * ApiException Constructor
     *
     * @param message  message
     */
    public ApiException(String message) {
        super(message);
    }

    /**
     * ApiException Constructor
     *
     * @param message  message
     * @param e Exception
     */
    public ApiException(String message, Exception e) {
        super(message, e);
    }
}
