package com.zc.rbmqrecv.recv;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rabbitmq.tools.json.JSONSerializable;
import com.rabbitmq.tools.json.JSONUtil;
import com.zc.rbmqrecv.bean.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceive {

//    @RabbitListener(queues="queue")
//    public void processC(String str) {
//        System.out.println("Receive:"+str);
//    }
    @RabbitListener(queues="topic.message")
    public void process1(String str) {
        System.out.println("message:"+str);
    }
    @RabbitListener(queues="topic.messages")
    public void process2(String str) {
        System.out.println("messages:"+str);
    }
}
