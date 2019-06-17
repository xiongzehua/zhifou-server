package com.xiongzehua.freetalk.aspect;

import com.xiongzehua.freetalk.common.Response;
import com.xiongzehua.freetalk.exception.BusinessException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by xiongzehua on 2019/2/21.
 */
@Aspect
@Component
public class ResponseAspect {
    @Around("execution(* com.xiongzehua.freetalk.controller.*.*(..))")
    public Response around(ProceedingJoinPoint joinPoint) {
        System.out.println("拦截");
        Response response = null;
        try {
            response = (Response) joinPoint.proceed();
        } catch (BusinessException businessException) {
            response = Response.error(businessException.getBusinessStatus());
        } catch (Throwable  ex) {
            System.out.println("出大问题了");
            response = Response.error();
        }
        return response;
    }
}
