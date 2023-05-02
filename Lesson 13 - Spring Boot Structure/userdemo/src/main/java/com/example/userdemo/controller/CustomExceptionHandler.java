package com.example.userdemo.controller;

import com.example.userdemo.error.BadRequestException;
import com.example.userdemo.error.ErrorResponse;
import com.example.userdemo.error.UserNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UserNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(UserNotFoundExeption ex, WebRequest req){
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleBadRequestException(BadRequestException ex, WebRequest req){
        return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleException(Exception ex, WebRequest req){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }


    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleBindException(BindException e){
        String errorMessage = "Request is not valid. Detail errors:";
        if (e.getBindingResult().hasErrors()){
            List<String> defaultMessages = e.getBindingResult().getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
            defaultMessages.add(0,errorMessage);
            errorMessage = String.join("\n",defaultMessages);
        }


        return  new ErrorResponse(HttpStatus.BAD_REQUEST, errorMessage);


    }


}
