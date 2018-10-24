package com.example.only.service.caffeine;

import com.example.only.configuration.CaffeineCacheEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Author: created by liguoliang
 * Date: 2018/10/24 10:55 55
 * Version: 1.0
 * Function: 用于
 */
@Service
@Slf4j
public class LocalCacheManager {
    private static final String cacheName = "DEFAULT_CACHE";

    @Cacheable(cacheNames = {cacheName})
    public String getDataFromCache(String str1, String str2) {
        log.info("缓存数据{};{}",str1,str2);
        return str1 + str2;
    }

    @CacheEvict(allEntries = true, cacheNames = {cacheName})
    @Scheduled(fixedRate = 600000)//单位毫秒
    public void cacheEvict() {
        log.info("清空数据集缓存");
    }
}
