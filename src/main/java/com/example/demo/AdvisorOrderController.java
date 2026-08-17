package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvisorOrderController {
    private final ChatClient client;

    public AdvisorOrderController(@Qualifier("baseChatClient") ChatClient client){
        this.client=client;
    }

    @GetMapping("/api/chat")
    String chatResponse(@RequestParam String message){
        return client.prompt().user(message).call().content();
    }
}
