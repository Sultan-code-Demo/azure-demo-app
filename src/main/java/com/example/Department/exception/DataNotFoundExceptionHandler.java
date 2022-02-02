package com.example.Department.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataNotFoundExceptionHandler {

    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException exception){
        ActualException ex = new ActualException(exception.getMessage());
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

}
