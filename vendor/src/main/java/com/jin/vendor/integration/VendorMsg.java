package com.jin.vendor.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

public interface VendorMsg {
    String V_RECEIVE = "mreceive";
    String V_SEDD = "msend";

    @Input(V_SEDD)
    SubscribableChannel receive();

    @Output(V_RECEIVE)
    MessageChannel send();

}
