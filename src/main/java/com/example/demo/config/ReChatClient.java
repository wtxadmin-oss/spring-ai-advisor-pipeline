package com.example.demo.config;

import com.example.demo.ReReadingAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReChatClient {
    @Bean
    public ReReadingAdvisor reReadingAdvisor(){
        return new ReReadingAdvisor();
    }
    @Bean
    public ChatClient rechatClient(ChatClient.Builder rebuilder,ReReadingAdvisor reReadingAdvisor){
        return rebuilder.defaultAdvisors(reReadingAdvisor).build();
    }
}
