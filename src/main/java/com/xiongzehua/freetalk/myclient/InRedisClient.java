package com.xiongzehua.freetalk.myclient;
import java.io.IOException;
import java.util.HashMap;

public class InRedisClient {
    private static HashMap<String, String> hashMap = new HashMap<>();
    private static InRedisClient inRedisClient = new InRedisClient();
    private InRedisClient() {
    }
    public static InRedisClient getInRedisClient() {
        return inRedisClient;
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
