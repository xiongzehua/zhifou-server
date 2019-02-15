package com.xiongzehua.zhifou.common;

import java.util.HashMap;


/**
 * 返回数据
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class ResponseCode extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private static final int SUCCESS = StatusCode.SUCCESS.getCode();
    private static final int ERROR = StatusCode.FAILURE.getCode();
    private static final String SUCCESS_MSG = StatusCode.SUCCESS.getMsg();
    private static final String ERROR_MSG = StatusCode.FAILURE.getMsg();
    private static final int INITIAL = 4;
    private static final String MSG = "msg";
    private static final String CODE = "code";
    private static final String RESUTLT = "result";


    public ResponseCode() {
        super();
    }

    public ResponseCode(int initialCapacity) {
        super(initialCapacity);
    }

    public static ResponseCode ok(int code, String msg) {
        //initialCapacity = (需要存储的元素个数 / 负载因子) + 1。注意负载因子（即loader factor）默认为 0.75，如果暂时无法确定初始值大小，请设置为 16
        ResponseCode r = new ResponseCode(INITIAL);
        r.put(CODE, code);
        r.put(MSG, msg);
        return r;
    }

    public static ResponseCode ok() {
        return ok(SUCCESS, SUCCESS_MSG);
    }

    public static ResponseCode ok(int code) {
        return ok().put(CODE, code);
    }

    public static ResponseCode ok(String msg) {
        return ok().put(MSG, msg);
    }


    public static ResponseCode ok(Object data) {
        return ok().put(RESUTLT, data);
    }

    public static ResponseCode result(Object data) {
        return ok().put(RESUTLT, data);
    }

    public static ResponseCode ok(String msg, Object data) {
        return ok(msg).put(RESUTLT, data);
    }

    public static ResponseCode ok(StatusCode status) {
        return ok().put(MSG, status.getMsg()).put(CODE, status.getCode());
    }


    public static ResponseCode error(int code, String msg) {
        ResponseCode r = new ResponseCode(INITIAL);
        r.put(CODE, code);
        r.put(MSG, msg);
        return r;
    }

    public static ResponseCode error() {
        return error(ERROR, ERROR_MSG);
    }

    public static ResponseCode error(String msg) {
        return error(ERROR, msg);
    }

    public static ResponseCode error(Object data) {
        return ok().put(RESUTLT, data);
    }

    public static ResponseCode error(StatusCode status) {
        return ok().put(MSG, status.getMsg()).put(CODE, status.getCode());
    }

    @Override
    public ResponseCode put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    @SuppressWarnings("unchecked")
    public ResponseCode add(String key, Object value) {
        Object object = super.getOrDefault(RESUTLT, new HashMap<>());
        try {
            HashMap<String, Object> result = (HashMap<String, Object>) object;
            result.put(key, value);
            super.put(RESUTLT, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}
