package com.example.config;

import com.example.mcp.config.McpServerConfig;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {
    @Autowired
    private ToolCallbackProvider toolCallbackProvider;

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultSystem("你是一个图书管理员助手，可以帮助用户查询图书信息。"+
                        "你可以根据书名来进行模糊查询、根据作者查询和根据分类查询图书。"+
                        "回复的时候，请使用简洁友好的语言，并且将图书信息整理为易读的格式。")
                //注册工具方法
                .defaultTools(toolCallbackProvider)
                .build();
    }
}
