package org.example.exception;


import org.example.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BackendServiceException.class)
    public ResponseEntity<ErrorResponse> handleBackendServiceException(BackendServiceException ex) {
        // Create ErrorResponse object with details from the custom exception
        ErrorResponse errorResponse = new ErrorResponse(ex.getHttpCode(), ex.getHttpMessage(), ex.getMoreInformation());

        // Return the response with the extracted details
        return ResponseEntity.status(ex.getHttpCode()).body(errorResponse);
    }
}

