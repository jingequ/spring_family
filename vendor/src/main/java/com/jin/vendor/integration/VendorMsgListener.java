package com.jin.vendor.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class VendorMsgListener {


    @StreamListener(VendorMsg.V_SEDD)
    public void receive(String msg){
        System.out.println("vendor receive a msg = " + msg +" !");
    }


}
