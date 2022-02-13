package rest.koios.client.backend.api.base.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * ApiException
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ApiException extends Exception {

    /**
     * details
     */
    private String details;

    /**
     * code
     */
    private int code;

    /**
     * message
     */
    private String message;

    /**
     * ApiException Constructor
     *
     * @param errorBody  errorBody
     * @param statusCode statusCode
     */
    public ApiException(String errorBody, HttpStatus statusCode) {
        this.message = errorBody;
        this.code = statusCode.value();
        this.details = statusCode.getReasonPhrase();
    }
}
