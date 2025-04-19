package com.example.model;

import java.io.Serializable;

public class ChatRequest implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ChatRequest(String message) {
        this.message = message;
    }

    public ChatRequest() {
    }
}
