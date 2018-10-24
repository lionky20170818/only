package com.example.only.test;

import com.example.only.OnlyApplication;
import com.example.only.OnlyApplicationTests;
import com.example.only.service.event.EventPublisher;
import com.example.only.service.event.MyEvent;
import com.example.only.service.event.MyListener2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Author: created by liguoliang
 * Date: 2018/10/23 15:41 41
 * Version: 1.0
 * Function: 用于:Spring事件监听
 * https://blog.csdn.net/ignorewho/article/details/80702827四中方式
 */
public class SpringApplicationEventTest extends OnlyApplicationTests {
    @Autowired
    private EventPublisher publisher = null;

    //第一种监听方式Event
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(OnlyApplication.class, args);
        //装载事件
        context.addApplicationListener(new MyListener2());
        //发布事件
        context.publishEvent(new MyEvent("测试事件.","你好"));

    }

    //第二种监听方式Event
    @Test
    public  void Test(){
        MyEvent event = new MyEvent("1111","哈哈");
        publisher.pubishEvent(event);
    }

}


