package com.jin.demo.scheduler;

import com.jin.demo.dao.model.MyEvenet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class MyEventListener {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @EventListener
    public void listen(MyEvenet myEvenet) {
        log.info("MyEventListener doing ! msg = {}", myEvenet.getMsg());
    }
}
