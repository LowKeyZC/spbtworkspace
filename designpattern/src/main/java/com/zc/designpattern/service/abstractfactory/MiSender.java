package com.zc.designpattern.service.abstractfactory;

public class MiSender implements Sender,Caller {
    @Override
    public void send() {
        System.out.println("mi send!");
    }

    @Override
    public void call() {
        System.out.println("mi call!");
    }
}
