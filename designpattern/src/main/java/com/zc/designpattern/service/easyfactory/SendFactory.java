package com.zc.designpattern.service.easyfactory;

public class SendFactory {

    public static Send createEmailSender() {
        return new EmailSendImpl();
    }

    public static Send createMessageSender(){
        return new MessageSendImpl();
    }
}
