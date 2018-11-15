package com.zc.designpattern.service.easyfactory;

/**
 * 简单工厂模式(静态工厂方法模式),就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 * https://blog.csdn.net/zhangerqing/article/details/8194653
 * 发送消息：短信/邮件
 */
public class Test {
    public static void main(String[] args) {
        Send messageSender = SendFactory.createMessageSender();
        messageSender.send();
        Send emailSender = SendFactory.createEmailSender();
        emailSender.send();
    }
}
