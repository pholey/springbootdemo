package com.velocity.practice.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalCustomerExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity handleNotFoundException(CustomerNotFoundException notFoundException){
        return new ResponseEntity(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
