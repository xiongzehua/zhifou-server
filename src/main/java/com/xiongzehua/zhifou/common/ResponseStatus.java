package com.xiongzehua.zhifou.common;

/**
 * Created by xiongzehua on 2019/2/16.
 */
public enum ResponseStatus {
    // 默认状态
    SUCCESS(0, "成功"),
    ERROR(1, "失败"),
    // 自定义状态
    NEED_LOGIN(1, "请先登录"),
    ZIDINGYI(1, "自定义"),
    ;

    private final int code;
    private final String message;

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}