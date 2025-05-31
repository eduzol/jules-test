package com.example.mathservice.dto;

public class ApiResponse {
    private Object result;

    public ApiResponse(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
