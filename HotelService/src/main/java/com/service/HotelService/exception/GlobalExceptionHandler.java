package com.service.HotelService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handlerResourceNotFoundException(ResourceNotFoundException exception) {

        Map<String, Object> response = new HashMap<>();
        response.put("message", exception.getMessage());
        response.put("status", HttpStatus.NOT_FOUND);
        response.put("success", true);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
