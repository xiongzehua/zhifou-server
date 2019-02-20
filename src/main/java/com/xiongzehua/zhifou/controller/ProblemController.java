package com.xiongzehua.zhifou.controller;

import com.xiongzehua.zhifou.common.Response;
import com.xiongzehua.zhifou.common.ResponseStatus;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 问题
 * @author: guomiaomiao
 * @date 2019/2/15 15:38:49
 */
@Api(tags = "登录接口", description = "ProblemController")
@RestController
@RequestMapping("/problem")
public class ProblemController {
    @RequestMapping(value = "/listPage", method = {RequestMethod.POST, RequestMethod.GET})
    public Response listPage() {
        // return Response.error(ResponseStatus.NEED_LOGIN, null);
        return Response.error(ResponseStatus.ZIDINGYI, null);
    }

}
