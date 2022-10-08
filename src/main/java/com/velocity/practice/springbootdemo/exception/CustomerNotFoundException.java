package com.velocity.practice.springbootdemo.exception;


public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(){}

    public CustomerNotFoundException(String message)
    {
        super(message);
    }
}
