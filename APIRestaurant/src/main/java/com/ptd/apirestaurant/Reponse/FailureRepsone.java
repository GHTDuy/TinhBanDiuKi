package com.ptd.apirestaurant.Reponse;

public class FailureRepsone {
    private String StatusCode;
    private String Message;

    public FailureRepsone(String message) {
        StatusCode = "500";
        Message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "StatusCode='" + StatusCode + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
