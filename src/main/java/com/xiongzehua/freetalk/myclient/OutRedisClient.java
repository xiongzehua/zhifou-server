package com.xiongzehua.freetalk.myclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class OutRedisClient {
    OutputStream outputStream;
    InputStream inputStream;
    private ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
    public OutRedisClient(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
    }
    public void set(String key, String value) throws IOException {
        hashMap.put(key, value);
        outputStream.write(hashMap.toString().getBytes());
        System.out.println("成功发送给redis服务器·····" + hashMap.toString());
    }

    public String get(String key) throws IOException {
        byte[] response = new byte[1024];
        inputStream.read(response);
        System.out.println("收到数据·······" + response.toString());
        return response.toString();
    }
}
