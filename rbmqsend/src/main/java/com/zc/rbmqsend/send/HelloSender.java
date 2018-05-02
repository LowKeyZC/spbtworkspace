package com.zc.rbmqsend.send;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate template;

    /**
     * direct模式exchange测试
     */
    public void sendDETest() {
        template.convertAndSend("queue","hello,rabbit~");
    }

    /**
     * topic模式exchange测试
     */
    public void sendTETest(){
        template.convertAndSend("exchange","topic.message","hello,rabbit!");
    }
}
