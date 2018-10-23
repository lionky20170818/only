package com.example.only.test;

import com.example.only.OnlyApplication;
import com.example.only.service.event.MyEvent;
import com.example.only.service.event.MyListener2;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Author: created by liguoliang
 * Date: 2018/10/23 15:41 41
 * Version: 1.0
 * Function: 用于:Spring事件监听
 * https://blog.csdn.net/ignorewho/article/details/80702827四中方式
 */
public class SpringApplicationEvent {
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(OnlyApplication.class, args);
        //装载事件
        context.addApplicationListener(new MyListener2());
        //发布事件
        context.publishEvent(new MyEvent("测试事件."));

    }
}


