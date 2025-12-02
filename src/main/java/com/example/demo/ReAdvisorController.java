package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReAdvisorController {
    private final ChatClient rechatClient;
    public ReAdvisorController(ChatClient rechatClient){
        this.rechatClient=rechatClient;
    }
    @GetMapping("/reai")
    public String recall(String input){
        return rechatClient.prompt(input).call().content();
    }
}
