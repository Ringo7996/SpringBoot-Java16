package com.example.login.error;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}