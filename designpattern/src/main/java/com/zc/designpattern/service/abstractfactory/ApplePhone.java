package com.zc.designpattern.service.abstractfactory;

public class ApplePhone implements Sender,Caller {
    @Override
    public void call() {
        System.out.println("apple call!");
    }

    @Override
    public void send() {
        System.out.println("apple send!");
    }
}
