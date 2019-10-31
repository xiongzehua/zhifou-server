package com.xiongzehua.freetalk.myclient;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InSpringRedisClient {
    private ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
    public InSpringRedisClient() {
    }
    public void set(String key, String value) throws IOException {
        hashMap.put(key, value);
        System.out.println("set成功数据:" + hashMap.toString());
    }
    public String get(String key) throws IOException {
        String value = hashMap.get(key);
        System.out.println("get成功数据:" + value.toString());
        return value;
    }
}
