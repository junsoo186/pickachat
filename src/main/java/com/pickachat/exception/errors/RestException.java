package com.pickachat.exception.errors;

import org.springframework.http.HttpStatus;

public class RestException extends RuntimeException {

    public RestException(String message) {
        super(message);
    }
}
