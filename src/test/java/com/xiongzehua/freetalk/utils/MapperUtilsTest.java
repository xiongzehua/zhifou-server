package com.xiongzehua.freetalk.utils;

import org.junit.Test;

/**
 * @author xiongzehua
 * @date 2019-06-17 13:50
 */
public class MapperUtilsTest {

    @Test
    public void stringToSHA256() {
        System.out.println(MapperUtils.stringToSHA256("阿斯达"));
        System.out.println(MapperUtils.stringToSHA256("aaa钱钱钱钱钱钱钱钱钱钱钱钱钱钱钱钱钱钱钱去问驱蚊器饿我去额为亲请问企鹅"));
        System.out.println(MapperUtils.stringToSHA256(""));
        System.out.println(MapperUtils.stringToSHA256("?aasd12s=+as09a阿斯顿"));
    }

    @Test
    public void stringToMD5() {
        System.out.println(1 - 0.9);
    }
}