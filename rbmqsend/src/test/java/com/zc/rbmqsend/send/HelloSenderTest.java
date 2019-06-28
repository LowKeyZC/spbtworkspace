package com.zc.rbmqsend.send;

import com.zc.rbmqsend.RbmqsendApplication;
import com.zc.rbmqsend.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest(classes=RbmqsendApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloSenderTest {

    @Resource
    private HelloSender helloSender;

    /*@Test
    public void testRabbit() {
        helloSender.sentTest("hello");
    }*/

    /*@Test
    public void testRabbit02(){
        helloSender.sendTETest();
    }*/
}