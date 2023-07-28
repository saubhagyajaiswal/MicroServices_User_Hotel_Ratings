package com.service.UserService.exception;

import com.service.UserService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception)   {

        String msg = exception.getMessage();
        ApiResponse apiResponse = ApiResponse.builder().message(msg).status(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
