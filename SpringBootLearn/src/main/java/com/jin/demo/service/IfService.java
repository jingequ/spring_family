package com.jin.demo.service;

import com.jin.demo.common.CommonStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Conditional(ConditionDemo.class)
public class IfService {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private CommonStr str;

    @Scheduled(cron = "0/2 * * * * *")
    public void do2() {
        System.out.println("I am scheduling , time -= " + format.format(new Date()));
        System.out.println(str.toString());
    }
}
