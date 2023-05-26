package com.leeonscoding.CRUDExample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorOutput> badRequestParamException(RuntimeException e) {
        return new ResponseEntity<>(
                new ErrorOutput("Bad message format. Please give a valid input"),
                HttpStatus.BAD_REQUEST);
    }
}
