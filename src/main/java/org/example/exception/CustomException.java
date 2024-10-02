package org.example.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private final String responseBody;
    private final HttpStatus httpStatus;

    public CustomException(String responseBody, HttpStatus httpStatus) {
        super("Error occurred with status code: " + httpStatus);
        this.responseBody = responseBody;
        this.httpStatus = httpStatus;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

