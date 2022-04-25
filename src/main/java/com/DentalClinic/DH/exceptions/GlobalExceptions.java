package com.DentalClinic.DH.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptions {
    private static final Logger LOGGER = Logger.getLogger(GlobalExceptions.class.getName());
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        LOGGER.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> badRequestExceptionHandler(BadRequestException ex){
        LOGGER.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
