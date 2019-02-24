package com.xiongzehua.zhifou.controller;

import com.xiongzehua.zhifou.common.Response;
import com.xiongzehua.zhifou.pojo.User;
import com.xiongzehua.zhifou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户
 * @author xiongzehua
 * @date 2019/2/15 15:38:49
 */

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册功能
     * @param user 用户信息
     * @return
     */
    @PostMapping(value = "/signUp")
    public Response signUp(@RequestBody User user) {
        return Response.success(userService.signUp(user));
    }

    /**
     * 用户登录功能
     * @param user
     * @return 登录结果
     */
    @PostMapping(value = "/signIn")
    public Response signIn(@RequestBody User user) {
        return Response.success(userService.doSign(user));
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PostMapping(value = "/updateUser")
    public Response updateUser(@RequestBody User user) {
        return Response.success(userService.updateUser(user));
    }

    /**
     * 获得指定用户信息
     * @return
     */
    @GetMapping(value = "/getUser/{id}")
    public Response getUser(@PathVariable("id") Integer id) {
        return Response.success(userService.getUser(id));
    }

}
