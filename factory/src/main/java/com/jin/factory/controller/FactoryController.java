package com.jin.factory.controller;

import com.jin.factory.integration.FactoryMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RestController
public class FactoryController {

    @Autowired
    private FactoryMsg factoryMsg;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/send")
    public String send1(@RequestParam String msg) {
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println(factoryMsg);
        System.out.println(msg);
        factoryMsg.send().send(MessageBuilder.withPayload(msg).build());
        return  "Factory send a msg = " + msg;
    }
}
