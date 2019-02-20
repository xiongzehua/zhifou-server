package com.xiongzehua.zhifou.common;


/**
 * Created by xiongzehua on 2019/2/16.
 */
public class Response<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Response<T> success(T data){
        return new Response<T>(BusinessStatus.SUCCESS,  data);
    }

    public static <T> Response<T> success(String message, T data){
        return new Response<T>(BusinessStatus.SUCCESS.getCode(), message,  data);
    }

    public static <T> Response<T> success(BusinessStatus businessStatus, T data){
        return new Response<T>(businessStatus, data);
    }

    public static <T> Response<T> error(T data){
        return new Response<T>(BusinessStatus.ERROR, data);
    }

    public static <T> Response<T> error(String message, T data){
        return new Response<T>(BusinessStatus.ERROR.getCode(), message,  data);
    }

    public static <T> Response<T> error(BusinessStatus businessStatus, T data){
        return new Response<T>(businessStatus, data);
    }

    public Response() {
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(BusinessStatus businessStatus, T data) {
        this.code = businessStatus.getCode();
        this.message = businessStatus.getMessage();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
