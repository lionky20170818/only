package com.example.only.test;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import com.example.only.OnlyApplicationTests;
import com.example.only.dto.ParaReq;
import com.example.only.service.caffeine.LocalCacheManager;
import com.example.only.service.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Author: created by liguoliang
 * Date: 2018/10/24 11:09 09
 * Version: 1.0
 * Function: 用于
 */
@Slf4j
public class LocalCacheTest extends OnlyApplicationTests {
    @Autowired
    LocalCacheManager localCacheManager;

    @Test
    public  void CacheTest() throws InterruptedException {
        String resp1 = localCacheManager.getDataFromCache("1a","2b");
        log.info("第一次获取结果{}",resp1);
        String resp2 = localCacheManager.getDataFromCache("1a","2b");
        log.info("第二次获取结果{}",resp2);

        Thread.sleep(6000);
        String resp3 = localCacheManager.getDataFromCache("1a","2b");
        log.info("第三次获取结果{}",resp3);
    }

    /**
     * hutool主要功能有缓存、Json工具、加密解密、定时任务等
     * https://blog.csdn.net/jui121314/article/details/83036640
     */
    @Test
    public  void hutoolTest() throws InterruptedException {
        //构建一个LRUCache（最久未使用缓存）
        int capacity = 2;//缓存个数
        Cache<String,ParaReq> lruCache = CacheUtil.newLRUCache(capacity,7000);
        ParaReq para = new ParaReq();
        para.setType100("11000");
        lruCache.put("test",para);
        log.info("第一次获取结果{}",lruCache.get("test"));
        Thread.sleep(8000);
        log.info("第二次获取结果{}",lruCache.get("test"));


    }
}
