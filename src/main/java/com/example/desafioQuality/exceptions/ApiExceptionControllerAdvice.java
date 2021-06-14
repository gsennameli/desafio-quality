package com.example.desafioQuality.exceptions;

import com.example.desafioQuality.dtos.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ApiExceptionControllerAdvice {
    @ExceptionHandler(value = { MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleDefault(MethodArgumentNotValidException ex, WebRequest request) {
        var responseBody = new ErrorResponseDTO();
        responseBody.setMessage(ex.getFieldError().getDefaultMessage());
        responseBody.setCause(ex.getFieldError().getField());
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { NoSuchElementException.class})
    protected ResponseEntity<Object> handleDistrictNotFound(NoSuchElementException ex, WebRequest request) {
        var responseBody = new ErrorResponseDTO();
        responseBody.setMessage(ex.getMessage());
        responseBody.setCause("prop_district");
        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }
}
