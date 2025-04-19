package com.example.mcp.config;

import com.example.service.BookService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MCP服务器配置类，负责注册MCP工具，用于定义与书籍服务相关的工具回调提供者
 */
@Configuration
public class McpServerConfig {

    /**
     * 创建一个工具回调提供者，用于处理与书籍服务相关的回调
     *
     * @param bookService 书籍服务接口，提供书籍相关的业务逻辑
     * @return 返回配置好的 {@link ToolCallbackProvider} 对象
     */
    @Bean
    public ToolCallbackProvider bookToolCallbackProvider(BookService bookService){
        return MethodToolCallbackProvider.builder()
                .toolObjects(bookService)
                .build();
    }
}
