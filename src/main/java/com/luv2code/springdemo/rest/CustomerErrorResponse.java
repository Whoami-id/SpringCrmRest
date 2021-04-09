
package com.luv2code.springdemo.rest;

public class CustomerErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    public CustomerErrorResponse() {

    }

    public CustomerErrorResponse(final int status, final String message, final long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(final long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
