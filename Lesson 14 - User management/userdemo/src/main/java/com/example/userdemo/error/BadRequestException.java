package com.example.userdemo.error;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }


}
