package com.example.only;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OnlyApplication {

    public static void main(String[] args) {
        //启动时监听方式Event
        ConfigurableApplicationContext context = SpringApplication.run(OnlyApplication.class, args);
        context.stop();
    }
}
