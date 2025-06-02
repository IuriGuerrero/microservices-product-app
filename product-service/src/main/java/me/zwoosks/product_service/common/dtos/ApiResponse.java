package me.zwoosks.product_service.common.dtos;

import java.time.LocalDateTime;

public class ApiResponse {

    private int stauts;
    private String message;
    private LocalDateTime timeStamp;

    public ApiResponse(int status, String message, LocalDateTime timeStamp) {
        this.stauts = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStauts() {
        return stauts;
    }

    public void setStauts(int stauts) {
        this.stauts = stauts;
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
