package com.example.japworkshop.exception.controller;

import com.example.japworkshop.exception.NoSuchClientException;
import com.example.japworkshop.exception.NoSuchDepartmentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoSuchDepartmentException.class)
    public ResponseEntity<String> noSuchDepartmentException(NoSuchDepartmentException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchClientException.class)
    public ResponseEntity<String> noSuchClientException(NoSuchClientException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

}
