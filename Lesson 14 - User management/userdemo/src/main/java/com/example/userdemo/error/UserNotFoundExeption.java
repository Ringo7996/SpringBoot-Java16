package com.example.userdemo.error;

public class UserNotFoundExeption extends RuntimeException{

    public UserNotFoundExeption(String message){
        super(message);
    }

}
