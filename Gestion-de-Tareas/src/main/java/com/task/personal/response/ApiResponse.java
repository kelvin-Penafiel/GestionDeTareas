package com.task.personal.response;

public class ApiResponse<T> {
    private HeaderApp headerApp;
    private T data;

    // Constructor, Getters, Setters
    public ApiResponse(HeaderApp headerApp, T data) {
        this.headerApp = headerApp;
        this.data = data;
    }

    public HeaderApp getHeaderApp() {
        return headerApp;
    }

    public void setHeaderApp(HeaderApp headerApp) {
        this.headerApp = headerApp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
