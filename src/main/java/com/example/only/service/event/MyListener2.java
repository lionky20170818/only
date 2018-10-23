package com.example.only.service.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Author: created by liguoliang
 * Date: 2018/10/23 17:17 17
 * Version: 1.0
 * Function: 用于
 */
@Component
@Slf4j
public class MyListener2 implements ApplicationListener<MyEvent> {
    public void onApplicationEvent(MyEvent event)	{
        log.info(String.format("%s监听到事件源：%s.", MyListener2.class.getName(), event.getSource()));
    }
}

