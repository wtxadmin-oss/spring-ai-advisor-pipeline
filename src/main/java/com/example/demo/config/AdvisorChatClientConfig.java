package com.example.demo.config;

import com.example.demo.ReReadingAdvisor;
import com.example.demo.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdvisorChatClientConfig {
    @Bean
    public ReReadingAdvisor reReadingAdvisor(){
        return new ReReadingAdvisor().withOrder(10);
    }

    @Bean
    public SimpleLoggerAdvisor simpleLoggerAdvisor() {
        return new SimpleLoggerAdvisor();
    }

    @Bean("baseChatClient")
    public ChatClient baseChatClient(ChatClient.Builder builder) {
        return builder.build();
    }

    @Bean("advisorChatClient")
    public ChatClient advisorChatClient(
            ChatClient.Builder builder,
            ReReadingAdvisor reReadingAdvisor,
            SimpleLoggerAdvisor simpleLoggerAdvisor) {
        return builder.defaultAdvisors(simpleLoggerAdvisor, reReadingAdvisor).build();
    }
}
