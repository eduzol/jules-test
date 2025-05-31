package com.example.mathservice.exception;

import com.example.mathservice.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // As per original request, though BAD_REQUEST is more typical
    public ResponseEntity<ApiResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        // String errorMessage = "Error: Invalid input. Please provide integers only for parameter: " + ex.getName();
        // For now, using the general message as requested.
        ApiResponse errorResponse = new ApiResponse("Error: Invalid input. Please provide integers only.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiResponse> handleGenericException(Exception ex) {
        // It's good practice to log the exception here:
        // import org.slf4j.Logger;
        // import org.slf4j.LoggerFactory;
        // private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
        // log.error("Unexpected error:", ex);
        ApiResponse errorResponse = new ApiResponse("Error: An unexpected error occurred.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
