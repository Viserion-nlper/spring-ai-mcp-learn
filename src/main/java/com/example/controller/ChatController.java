package com.example.controller;


import com.example.model.ChatRequest;
import com.example.model.ChatResponse;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 聊天控制器，处理AI聊天请求
 */
@RestController
@RequestMapping("/ai/chat")
public class ChatController {

    @Resource
    private ChatClient chatClient;

    /**
     * 与AI模型进行聊天交互
     *
     * @param request 包含用户输入消息的请求对象
     * @return 包含聊天响应的ResponseEntity对象
     * @throws Exception 当与AI模型交互发生异常时抛出
     */
    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request){
        try {
            //创建用户信息
            String UserMessage = request.getMessage();

            //使用流式API调用聊天
            String content = chatClient.prompt()
                    .user(UserMessage)
                    .call()
                    .content();
            return ResponseEntity.ok(new ChatResponse(content));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ChatResponse("处理AI模型chat请求时出错:"+e.getMessage()));
        }

    }
}
