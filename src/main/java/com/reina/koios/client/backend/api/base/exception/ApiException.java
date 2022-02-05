package com.reina.koios.client.backend.api.base.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
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
