package com.example.only.test;

import com.example.only.OnlyApplicationTests;
import com.example.only.service.caffeine.LocalCacheManager;
import com.example.only.service.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
