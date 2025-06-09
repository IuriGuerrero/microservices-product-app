package me.iguerrero.inventory_service.common.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiResponse {

    private int status;
    private String message;
    private LocalDateTime timeStamp;

    public ApiResponse(int status, String message, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public ApiResponse(HttpStatus httpStatus, String message, LocalDateTime timeStamp) {
        this.status = httpStatus.value();
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

}
