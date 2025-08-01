package com.shivamaggarwal.weatherapi.exception;

public class VisualCrossingException extends RuntimeException {
    private final int statusCode;
    private final String responseBody;

    public VisualCrossingException(String message, int statusCode, String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
