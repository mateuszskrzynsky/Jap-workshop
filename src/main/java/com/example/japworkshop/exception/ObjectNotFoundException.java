package com.example.japworkshop.exception;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(HttpStatus httpStatus) {
        super(String.valueOf(httpStatus));
    }
}
