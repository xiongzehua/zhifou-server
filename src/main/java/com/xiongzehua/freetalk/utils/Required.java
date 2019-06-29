package com.xiongzehua.freetalk.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gmm
 * @ description
 * @ date create in 2019/6/29 21:22
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {
    /**
     * 必须参数
     * @return
     */
    String fileName() default "";
}
