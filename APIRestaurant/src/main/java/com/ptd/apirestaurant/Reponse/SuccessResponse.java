package com.ptd.apirestaurant.Reponse;

public class SuccessResponse {
    private String StatusCode;
    private String Message;

    public SuccessResponse(String statusCode,String message) {
        StatusCode = statusCode;
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
