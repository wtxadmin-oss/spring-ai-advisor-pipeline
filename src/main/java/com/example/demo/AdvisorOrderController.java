package com.example.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvisorOrderController {
    private final ChatClient client;
    String input1="你好我叫wtx";
    String input2="我是谁";
    public AdvisorOrderController(ChatClient client){
        this.client=client;
    }
    @GetMapping("/ai/1")
    String chatResponse1(String userinput){
        return client.prompt().user(userinput).call().content();
    }

}
