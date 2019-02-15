package com.xiongzehua.zhifou.common;
import org.apache.shiro.SecurityUtils;

import com.xiongzehua.zhifou.pojo.LoginUserDTO;

/**
 * Controller公共组件
 *
 * @author : guomiaomiao
 * @date : 2019/2/15 15:31
 */
public abstract class AbstractController {

    protected LoginUserDTO getUser() {
        return (LoginUserDTO) SecurityUtils.getSubject().getPrincipal();
    }

    protected Integer getId() {
        return getUser().getId();
    }

    protected String getName() {
        return getUser().getName();
    }

}
