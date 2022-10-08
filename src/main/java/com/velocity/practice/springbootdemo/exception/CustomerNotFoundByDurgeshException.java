package com.velocity.practice.springbootdemo.exception;

public class CustomerNotFoundByDurgeshException extends RuntimeException {
    public CustomerNotFoundByDurgeshException(String resourceName, String resourceType, Long resourceValue) {
        super(String.format("%s not found of type %s of value: %l",resourceName,resourceType,resourceValue));
    }
}
