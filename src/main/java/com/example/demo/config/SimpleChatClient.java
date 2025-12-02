//package com.example.demo.config;
//
//import com.example.demo.SimpleLoggerAdvisor;
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SimpleChatClient {
//    @Bean
//    public SimpleLoggerAdvisor simpleLoggerAdvisor(){
//    return new SimpleLoggerAdvisor();
//    }
//    @Bean
//    public ChatClient chatClient(ChatClient.Builder chatclientbuilder,SimpleLoggerAdvisor advisor){
//        return chatclientbuilder.defaultAdvisors(advisor).build();
//    }
//}
