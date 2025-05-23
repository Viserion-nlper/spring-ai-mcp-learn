package com.example.model;

/**
 * 聊天响应模型，包含AI模型返回的内容
 */
public class ChatResponse {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ChatResponse() {
    }

    public ChatResponse(String content) {
        this.content = content;
    }
}
