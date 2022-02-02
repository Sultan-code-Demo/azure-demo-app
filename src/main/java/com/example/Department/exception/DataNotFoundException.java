package com.example.Department.exception;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String message){
        super(message);
    }

    public DataNotFoundException(String message, Throwable ex){
        super(message, ex);
    }

}
