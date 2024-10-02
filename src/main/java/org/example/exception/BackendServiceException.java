package org.example.exception;

public class BackendServiceException extends RuntimeException {
    private final int httpCode;
    private final String httpMessage;
    private final String moreInformation;

    public BackendServiceException(int httpCode, String httpMessage, String moreInformation) {
        super(httpMessage);
        this.httpCode = httpCode;
        this.httpMessage = httpMessage;
        this.moreInformation = moreInformation;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public String getHttpMessage() {
        return httpMessage;
    }

    public String getMoreInformation() {
        return moreInformation;
    }
}

