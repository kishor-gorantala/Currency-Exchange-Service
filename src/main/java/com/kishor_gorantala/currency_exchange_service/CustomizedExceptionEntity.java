package com.kishor_gorantala.currency_exchange_service;

import java.time.LocalDateTime;

public class CustomizedExceptionEntity {

    private LocalDateTime Datetimestamp;
    private String message;
    private String details;

    public CustomizedExceptionEntity() {
    }

    public CustomizedExceptionEntity(LocalDateTime datetimestamp, String message, String details) {
        Datetimestamp = datetimestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getDatetimestamp() {
        return Datetimestamp;
    }

    public void setDatetimestamp(LocalDateTime datetimestamp) {
        Datetimestamp = datetimestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
