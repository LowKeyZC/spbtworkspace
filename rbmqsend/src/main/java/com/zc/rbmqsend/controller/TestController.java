package com.zc.rbmqsend.controller;

import com.zc.rbmqsend.send.HelloSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @Resource
    private HelloSender helloSender;

    @RequestMapping("test01")
    public void test(String type, String msg) {
        if ("1".equals(type)) {
            helloSender.sendToFanout(msg);
        }
        if ("2".equals(type)) {
            helloSender.sentToDirect(msg);
        }
        if ("3".equals(type)) {
            helloSender.sendToDefault(msg);
        }
        if ("4".equals(type)) {
            helloSender.sendToTopic(msg);
        }
//        helloSender.send("aaa");
    }
}
