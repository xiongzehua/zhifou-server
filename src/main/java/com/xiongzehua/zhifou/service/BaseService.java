package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.pojo.User;
import org.apache.shiro.SecurityUtils;

public class BaseService {

    protected User getUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
}
