package com.zc.rbmqsend.configuration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConf {
    /* fanout队列测试，fanout类型exchange把消息群发到所有绑定的queue */
    @Bean
    public Queue queueFanout1() {
        return new Queue("queueFanout1");
    }
    @Bean
    public Queue queueFanout2() {
        return new Queue("queueFanout2");
    }
    @Bean
    public Queue queueFanout3() {
        return new Queue("queueFanout3");
    }
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    @Bean
    public Binding bindingFanout1(@Qualifier("queueFanout1") Queue queueFanout1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueFanout1).to(fanoutExchange);
    }
    @Bean
    public Binding bindingFanout2(@Qualifier("queueFanout2") Queue queueFanout2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueFanout2).to(fanoutExchange);
    }
    @Bean
    public Binding bindingFanout3(@Qualifier("queueFanout3") Queue queueFanout3, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueFanout3).to(fanoutExchange);
    }

    /* direct测试，发消息带的routingkey 路由到相应的queue */
    @Bean
    public Queue queueDirect1() {
        return new Queue("queueDirect1");
    }
    @Bean
    public Queue queueDirect2() {
        return new Queue("queueDirect2");
    }
    @Bean
    public Queue queueDirect3() {
        return new Queue("queueDirect3");
    }
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }
    @Bean
    public Binding bindingDirect1(@Qualifier("queueDirect1") Queue queueDirect1,DirectExchange directExchange) {
        return BindingBuilder.bind(queueDirect1).to(directExchange).with("queueDirectKey1");
    }
    @Bean
    public Binding bindingDirect2(@Qualifier("queueDirect2") Queue queueDirect2,DirectExchange directExchange) {
        return BindingBuilder.bind(queueDirect2).to(directExchange).with("queueDirectKey2");
    }
    @Bean
    public Binding bindingDirect3(@Qualifier("queueDirect3") Queue queueDirect3,DirectExchange directExchange) {
        return BindingBuilder.bind(queueDirect3).to(directExchange).with("queueDirectKey3");
    }

    /* default测试.defaultExchange是一种特殊的DirectExchange，默认和所有队列绑定，routingkey是队列名 */
    @Bean
    public Queue queueDefault() {
        return new Queue("queueDefault");
    }

    /* topic测试 queue与topicExchange用模糊routingKey形式绑定，#匹配0个或多个单词，*匹配1个单词 */
    @Bean
    public Queue queueTopic1() {
        return new Queue("queueTopic1");
    }
    @Bean
    public Queue queueTopic2() {
        return new Queue("queueTopic2");
    }
    @Bean
    public Queue queueTopic3() {
        return new Queue("queueTopic3");
    }
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }
    @Bean
    public Binding bindingTopic1(@Qualifier("queueTopic1") Queue queueTopic1,TopicExchange topicExchange){
        return BindingBuilder.bind(queueTopic1).to(topicExchange).with("news.#");
    }
    @Bean
    public Binding bindingTopic2(@Qualifier("queueTopic2") Queue queueTopic2,TopicExchange topicExchange){
        return BindingBuilder.bind(queueTopic2).to(topicExchange).with("news.*");
    }
    @Bean
    public Binding bindingTopic3(@Qualifier("queueTopic3") Queue queueTopic3,TopicExchange topicExchange){
        return BindingBuilder.bind(queueTopic3).to(topicExchange).with("paper.#");
    }
}