package org.api.rt.DevWeek.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException buninessException)  {
        return new ResponseEntity<>(buninessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY); 
    }

    @ExceptionHandler(NoSuchElementException.class) 
    public ResponseEntity<String> handle(NoSuchElementException buninessException) {
        return new ResponseEntity<>(buninessException.getMessage(), HttpStatus.NOT_FOUND);
    }
    
}
