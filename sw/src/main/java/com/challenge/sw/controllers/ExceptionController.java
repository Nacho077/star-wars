package com.challenge.sw.controllers;

import com.challenge.sw.exceptions.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<InternalException> internalExceptionHandler(InternalException e) {
        System.out.println("Exception: " + e.getMessage() + ", " + e.getDescription());

        return ResponseEntity.status(e.getStatus()).body(e);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<InternalException> exceptionHandler(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new InternalException(e.getCause(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
