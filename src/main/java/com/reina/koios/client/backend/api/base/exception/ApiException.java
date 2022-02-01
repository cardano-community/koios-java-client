package com.reina.koios.client.backend.api.base.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApiException extends Exception {

    private String details;
    private int code;
    private String message;

    public ApiException(String errorBody, HttpStatus statusCode) {
        this.message = errorBody;
        this.code = statusCode.value();
        this.details = statusCode.getReasonPhrase();
    }
}
