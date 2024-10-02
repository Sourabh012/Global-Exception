package org.example.exception;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Handle custom exceptions thrown by ABC service
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        // Log the error details
        logger.error("Custom Exception: HTTP Status = {}, Response Body = {}", ex.getHttpStatus(), ex.getResponseBody());

        // Return the exact same response and HTTP status from XYZ service
        return new ResponseEntity<>(ex.getResponseBody(), ex.getHttpStatus());
    }

    // Handle HttpStatusCodeException from RestTemplate in ABC service
    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<String> handleHttpStatusCodeException(HttpStatusCodeException ex) {
        // Log the details of the exception including HTTP status and response body
        logger.error("HttpStatusCodeException: HTTP Status = {}, Response Body = {}", ex.getStatusCode(), ex.getResponseBodyAsString());

        // Return the same response and HTTP status from XYZ service
        return new ResponseEntity<>(ex.getResponseBodyAsString(), ex.getStatusCode());
    }

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        // Log the exception
        logger.error("An unexpected error occurred: {}", ex.getMessage());

        // Return a generic message and HTTP 500 status
        return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

