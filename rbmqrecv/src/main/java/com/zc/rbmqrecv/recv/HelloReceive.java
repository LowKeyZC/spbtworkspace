package com.zc.rbmqrecv.recv;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rabbitmq.tools.json.JSONSerializable;
import com.rabbitmq.tools.json.JSONUtil;
import com.zc.rbmqrecv.bean.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceive {

    /* fanout 接收 */
    @RabbitListener(queues="queueFanout1")
    public void processQueueFanout1(String str) {
        System.out.println("queueFanout1:"+str);
    }
    @RabbitListener(queues="queueFanout2")
    public void processQueueFanout2(String str) {
        System.out.println("queueFanout2:"+str);
    }
    @RabbitListener(queues="queueFanout3")
    public void processQueueFanout3(String str) {
        System.out.println("queueFanout3:"+str);
    }
    
    /* direct接收 */
    @RabbitListener(queues="queueDirect1")
    public void processQueueDirect1(String str) {
        System.out.println("queueDirect1:"+str);
    }
    @RabbitListener(queues="queueDirect2")
    public void processQueueDirect2(String str) {
        System.out.println("queueDirect2:"+str);
    }
    @RabbitListener(queues="queueDirect3")
    public void processQueueDirect3(String str) {
        System.out.println("queueDirect3:"+str);
    }

    /* defalut接收 */
    @RabbitListener(queues = "queueDefault")
    public void processQueueDefault(String str) {
        System.out.println("queueDefault:" + str);
    }

    /* topic接收 */
    @RabbitListener(queues = "queueTopic1")
    public void processQueueTopic1(String str) {
        System.out.println("queueTopic1:" + str);
    }
    @RabbitListener(queues = "queueTopic2")
    public void processQueueTopic2(String str) {
        System.out.println("queueTopic2:" + str);
    }
    @RabbitListener(queues = "queueTopic3")
    public void processQueueTopic3(String str) {
        System.out.println("queueTopic3:" + str);
    }
}
