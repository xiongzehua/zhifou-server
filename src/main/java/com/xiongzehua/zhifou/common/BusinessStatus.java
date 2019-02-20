package com.xiongzehua.zhifou.common;

/**
 * Created by xiongzehua on 2019/2/16.
 */
public enum BusinessStatus {
    // 默认状态
    SUCCESS(0, "成功"),
    ERROR(1, "未知原因"),
    // 自定义状态
    ACCOUNT_NEED_LOGIN(1, "请先登录"),

    ACCOUNT_WRONG_PASSWORD(1, "密码错误"),
    ACCOUNT_NOt_EXIST(1, "账号不存在"),
    ;

    private final int code;
    private final String message;

    BusinessStatus(int code, String message) {
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