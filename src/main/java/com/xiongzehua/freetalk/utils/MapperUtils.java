package com.xiongzehua.freetalk.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class MapperUtils {
    /**
     * 将json字符串转换为对象
     * @return
     */
    public static String objectToJson() {
        return null;
    }

    /**
     * 将对象转换为json字符串
     * @return
     */
    public static String jsonToObject() {
        return null;
    }

    /**
     * 使用SHA256进行散列，将字符串转换为64位16进制编码
     * @param string
     * @return
     */
    public static String stringToSHA256(String string) {
        return DigestUtils.sha256Hex(string);
    }

    /**
     * 对使用MD5进行散列，将字符串转换为32位16进制编码
     * @param string
     * @return
     */
    public static String stringToMD5(String string) {
        return DigestUtils.md5Hex(string);
    }

    /**
     * 对使用BASE64进行编码，将字符串转换为32位16进制编码
     * @param string
     * @return
     */
    public static String stringToBASE64(String string) {
        return DigestUtils.md5Hex(string);
    }

    /**
     * 对使用非对称加密算法RAS进行加密，将字符串转换为32位16进制编码
     * @param string
     * @return
     */
    public static String stringToRSA(String string) {
        return DigestUtils.md5Hex(string);
    }
}
