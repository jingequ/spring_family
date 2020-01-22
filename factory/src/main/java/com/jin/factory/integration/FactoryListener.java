package com.jin.factory.integration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class FactoryListener {

    @Autowired
    private FactoryMsg factoryMsg;

    @StreamListener(FactoryMsg.F_RECEIVE)
    @SendTo(FactoryMsg.F_send)
    public String receive(String msg){
        System.out.println("=== factory receive msg = " + msg + " !");
        msg = "factory done ! " + msg;
        System.out.println(msg);
//        factoryMsg.send().send(MessageBuilder.withPayload(msg).build());
        return msg;
    }
}
