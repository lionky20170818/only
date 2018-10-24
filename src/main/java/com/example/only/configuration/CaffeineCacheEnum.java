package com.example.only.configuration;

/**
 * Created by admin on 2018/7/3.
 */
public enum CaffeineCacheEnum {

    DEFAULT_CACHE("DEFAULT_CACHE", 5, 100000);

    private final String cacheName;
    private final int ttl;//超时时间
    private final int maxSize;

    CaffeineCacheEnum(String cacheName, int ttl, int maxSize) {
        this.cacheName = cacheName;
        this.ttl = ttl;
        this.maxSize = maxSize;
    }

    public String getCacheName() {
        return cacheName;
    }

    public int getTtl() {
        return ttl;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
