package com.zc.rbmqsend.configuration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConf {
//    @Bean
//    public Queue queue() {
//        return new Queue("queue");
//    }
    @Bean(name = "message")
    public Queue queueMessage(){
        return new Queue("topic.message");
    }
    @Bean(name="messages")
    public Queue queueMessages(){
        return new Queue("topic.messages");
    }
    @Bean
    public TopicExchange exchange(){
        TopicExchange topicExchange = new TopicExchange("exchange");
        return topicExchange;
    }
    @Bean
    Binding bindingExchangeMessage(@Qualifier("message")Queue queueMessage,TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages")Queue queueMessages,TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}