package com.xiongzehua.freetalk.utils;

import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gmm
 * @ description
 * @ date create in 2019/6/29 21:22
 */
@Slf4j
public class CheckUtil {
    public static List<String> validate(Object o) throws Exception {
        List<String> list = new ArrayList<>();
        //getDeclaredFields()拿到当前类的所有字段
        //isAnnotationPresent()如果指定类型的注释存在于此元素上,则结果为true
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(Required.class)) {
                //因为Object中的成员变量为private,所以要进行这个操作
                //当isAccessible()的结果是false时,不允许通过反射访问该字段
                field.setAccessible(true);
                Object value = null;
                try {
                    //返回指定对象Object上此 Field 表示的字段的值
                    value = field.get(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value == null || value.equals("")) {
                    Required required = field.getAnnotation(Required.class);
                    list.add(required.fileName() + "不能为空");
                }
            }
        }
        return list;
    }
}