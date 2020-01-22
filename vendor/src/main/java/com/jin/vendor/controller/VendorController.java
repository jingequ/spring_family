package com.jin.vendor.controller;

import com.jin.vendor.integration.VendorMsg;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
@RestController
@Slf4j
public class VendorController {

    @Autowired
    private VendorMsg vendorMsg;

    @RequestMapping("/vendor/get")
    @RateLimiter(name = "vendor")
    public String get(@RequestParam long id) {
        System.out.println(new Date());
        String msg = "id:" + String.valueOf(id);
        vendorMsg.send().send(MessageBuilder.withPayload(msg).build());
        return "Vendor product id = " + id;
    }

}
