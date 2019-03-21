package com.xiongzehua.zhifou.common;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by xiongzehua on 2019/2/16.
 */
@Data
@Accessors(chain = true)
public class Response {
    private int code;
    private String message;
    private Object data;

    public static  Response success(){
        return new Response()
                .setCode(BusinessStatus.SUCCESS.getCode())
                .setMessage(BusinessStatus.SUCCESS.getMessage());
    }

    public static  Response success(Object data){
        return new Response()
                .setCode(BusinessStatus.SUCCESS.getCode())
                .setMessage(BusinessStatus.SUCCESS.getMessage())
                .setData(data);
    }

    public static Response success(BusinessStatus businessStatus, Data data){
        return new Response()
                .setCode(businessStatus.getCode())
                .setMessage(businessStatus.getMessage())
                .setData(data);
    }


    public static Response error(){
        return new Response()
                .setCode(BusinessStatus.ERROR.getCode())
                .setMessage(BusinessStatus.ERROR.getMessage());
    }

    public static Response error(BusinessStatus businessStatus){
        return new Response()
                .setCode(businessStatus.getCode())
                .setMessage(businessStatus.getMessage());
    }
}
