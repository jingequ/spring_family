package com.jin.demo.dao.model;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class MyEvenet extends ApplicationEvent {
    private String msg;


    public MyEvenet(String msg) {
        super(msg);
        this.msg = msg;
    }
}
