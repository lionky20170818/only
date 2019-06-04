package com.example.only.test;

import com.example.only.OnlyApplication;
import com.example.only.OnlyApplicationTests;
import com.example.only.service.event.EventPublisher;
import com.example.only.service.event.MyEvent;
import com.example.only.service.event.MyListener2;
import com.example.only.service.mormal.SalesBillImportFileHandler;
import com.example.only.service.mormal.UploadHandler;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;

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

    @Autowired
    @Qualifier("DemoUploadHandler")
    private UploadHandler uploadHandler1 = null;
    @Autowired
    @Qualifier("SalesBillImportFileHandler")
    private UploadHandler uploadHandler2 = null;

    @Resource(name = "TestHandler")
    private UploadHandler uploadHandler3 = null;

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
    public  void event2Test(){
        MyEvent event = new MyEvent("1111","哈哈");
        publisher.pubishEvent(event);
    }

    @Test
    public void proxy2Test() {
        //代理设计模式测试
        UploadHandler test = new SalesBillImportFileHandler();
        String result = test.handleFile();
        System.out.println("=11="+result);

        //方式1：使用注解寻找
        System.out.println("=22="+uploadHandler1.handleFile());
        System.out.println("=33="+uploadHandler2.handleFile());
        System.out.println("=44="+uploadHandler3.handleFile());

        //方式二：使用list的para寻找
        //todo
        /*
        athena-openapi-service 工程下
        VehicleBillDataProcessServiceImpl.doPreHandlers()  方法
        */

        //方式三：使用type寻找
        //TODO
        /*
        athena-openapi-service 工程下
        OpenSalesBillStatusServiceImpl.billStatusModify(    方法
        */


    }

}


