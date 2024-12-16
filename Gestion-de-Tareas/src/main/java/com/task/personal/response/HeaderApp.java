package com.task.personal.response;

public class HeaderApp {
    private int code;
    private String message;

    // Constructor, Getters, Setters
    public HeaderApp(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
