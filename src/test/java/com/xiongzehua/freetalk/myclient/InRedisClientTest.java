package com.xiongzehua.freetalk.myclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InRedisClientTest {

    @Autowired
    private InSpringRedisClient inSpringRedisClient;

    @Test
    public void test1() throws IOException {
        InRedisClient inRedisClient = InRedisClient.getInRedisClient();
        inRedisClient.set("第一个", "2019.7.7");
        String value = inRedisClient.get("第一个");
    }

    @Test
    public void test2() throws IOException {
        inSpringRedisClient.set("第二个", "2019.7.8");
        String value = inSpringRedisClient.get("第二个");
    }

    @Test
    public void test3() throws IOException {
        OutRedisClient outRedisClient = new OutRedisClient("212.64.15.67", 6379);
        outRedisClient.set("第三个", "2019.7.9");
        String value = outRedisClient.get("第三个");
    }
}
