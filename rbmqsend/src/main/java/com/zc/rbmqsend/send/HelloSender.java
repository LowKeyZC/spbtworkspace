package com.zc.rbmqsend.send;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class HelloSender {
    @Resource
    private AmqpTemplate template;

    public void sendToFanout(String msg) {
        template.convertAndSend("fanoutExchange", "", msg);
    }

    public void sentToDirect(String msg) {
        template.convertAndSend("directExchange", "queueDirectKey1", msg);
        template.convertAndSend("directExchange", "queueDirectKey2", msg);
        template.convertAndSend("directExchange", "queueDirectKey3", msg);
    }

    public void sendToDefault(String msg) {
        template.convertAndSend("queueDefault",msg);
    }

    public void sendToTopic(String msg) {
        template.convertAndSend("topicExchange", "news.usa", msg);
        template.convertAndSend("topicExchange", "news.a.b", msg);
        template.convertAndSend("topicExchange", "paper.usa", msg);
    }
}
