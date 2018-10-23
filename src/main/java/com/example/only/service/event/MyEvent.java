package com.example.only.service.event;

import org.springframework.context.ApplicationEvent;

/**
 * Author: created by liguoliang
 * Date: 2018/10/23 17:19 19
 * Version: 1.0
 * Function: 用于
 */
@SuppressWarnings("serial")
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source){
        super(source);
    }
}
