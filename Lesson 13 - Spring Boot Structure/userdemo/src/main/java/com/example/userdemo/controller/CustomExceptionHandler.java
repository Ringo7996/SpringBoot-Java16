package com.example.userdemo.controller;

import com.example.userdemo.error.ErrorResponse;
import com.example.userdemo.error.NotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundExeption ex, WebRequest req){
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

}
