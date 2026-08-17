package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReAdvisorController {
    private final ChatClient rechatClient;
    public ReAdvisorController(@Qualifier("advisorChatClient") ChatClient rechatClient){
        this.rechatClient=rechatClient;
    }

    @GetMapping("/api/chat/re-read")
    public String recall(@RequestParam String message){
        return rechatClient.prompt(message).call().content();
    }
}
