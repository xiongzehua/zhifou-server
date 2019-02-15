package com.xiongzehua.zhifou.common;

/**
 * 业务状态码
 *
 * @author : HejinYo   hejinyo@gmail.com
 * date : 2017/8/5 18:25
 */
public enum StatusCode {
    FAILURE(-1, "失败"),
    NO_EXIT(1, "查询数据不存在"),
    SUCCESS(0, "成功");

    private final int code;
    private final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}