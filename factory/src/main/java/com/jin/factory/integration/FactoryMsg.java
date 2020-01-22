package com.jin.factory.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface FactoryMsg {
    String F_RECEIVE = "mreceive";
    String F_send = "msend";

    @Input(F_RECEIVE)
    SubscribableChannel receive();

    @Output(F_send)
    MessageChannel send();
}
