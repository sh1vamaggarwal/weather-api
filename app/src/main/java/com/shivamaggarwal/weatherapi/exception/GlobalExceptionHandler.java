package com.shivamaggarwal.weatherapi.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(VisualCrossingException.class)
    public ResponseEntity<Map<String, Object>> handleVisualCrossingException(VisualCrossingException ex) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("error", "External API error");
        errorBody.put("message", ex.getMessage());
        errorBody.put("status", ex.getStatusCode());
        errorBody.put("timestamp", Instant.now());

        return ResponseEntity.status(ex.getStatusCode()).body(errorBody);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("error", "Internal server error");
        errorBody.put("message", ex.getMessage());
        errorBody.put("timestamp", Instant.now());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorBody);
    }
}
