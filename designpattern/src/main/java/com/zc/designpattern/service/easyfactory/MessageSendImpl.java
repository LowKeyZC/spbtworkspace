package com.zc.designpattern.service.easyfactory;

public class MessageSendImpl implements Send{
    @Override
    public void send() {
        System.out.println("send a message!");
    }
}
