package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, Object>> handBadRequest(BadRequestException e){
       Map<String, Object> body = new LinkedHashMap<>();

       body.put("message", e.getMessage());
       body.put("timestamp", LocalDateTime.now());
       body.put("errors", new LinkedHashSet<>());
       body.put("status", HttpStatus.BAD_REQUEST.value());

       return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handResourceNotFound(ResourceNotFoundException e){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", e.getMessage());
        body.put("timestamp", LocalDateTime.now());
        body.put("errors", new LinkedHashSet<>());
        body.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
