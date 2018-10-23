package com.example.only.service.event;

import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Author: created by liguoliang
 * Date: 2018/10/23 17:32 32
 * Version: 1.0
 * Function: 用于
 */
@Component
public class MyEventHandle {
    /**
     * 监听spring的事件（运用停止事件,Application.stop()方法时候监听到。
     *
     */
    @EventListener
    public void eventStop(ContextStoppedEvent event){
        System.out.println("应用停止事件==========："+event.getClass());
    }

}
