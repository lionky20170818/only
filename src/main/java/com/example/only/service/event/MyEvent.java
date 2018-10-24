package com.example.only.service.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * Author: created by liguoliang
 * Date: 2018/10/23 17:19 19
 * Version: 1.0
 * Function: 用于
 */
@SuppressWarnings("serial")
//@Data
public class MyEvent extends ApplicationEvent {
    private String flag;

    public MyEvent(Object source, String flag) {
        super(source);
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
