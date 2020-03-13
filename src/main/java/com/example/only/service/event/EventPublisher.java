package com.example.only.service.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 模块名称:
 * 说明:
 * JDK 版本: JDK1.8
 * 创建日期：2017/3/8
 */

@Component
public class EventPublisher<T>  implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void pubishEvent(T event) {
        this.publisher.publishEvent(event);
    }
}
