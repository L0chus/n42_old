package com.example.application.service.exceptions;

public class DatabaseLayerException extends Throwable {
    private String reason = null;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public DatabaseLayerException( String reason ) {
        this.reason = reason;
    }
}
