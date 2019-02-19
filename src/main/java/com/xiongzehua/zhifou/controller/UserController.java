package com.xiongzehua.zhifou.controller;

import com.xiongzehua.zhifou.common.Response;
import com.xiongzehua.zhifou.pojo.User;
import com.xiongzehua.zhifou.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signIn")
    public Response signIn(User user) {
        return null;
    }

    @GetMapping("/hello")
    public Response signIn( ) {
        return Response.success("hello");
    }

}
