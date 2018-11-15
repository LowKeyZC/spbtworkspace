package com.zc.designpattern.service.easyfactory;

public class EmailSendImpl implements Send {
    @Override
    public void send() {
        System.out.println("send a email!");
    }
}
