package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.common.Response;
import com.xiongzehua.zhifou.common.ResponseStatus;
import com.xiongzehua.zhifou.dao.UserMapper;
import com.xiongzehua.zhifou.exception.RRException;
import com.xiongzehua.zhifou.pojo.User;
import com.xiongzehua.zhifou.util.TokenUtil;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

/**
 * 用户管理操作
 * @author xiongzehua
 * @date 2019/2/15 15:38:49
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 用户注册功能
     * @param user 用户信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Response signUp(User user) {
        user.setPassword(new Sha256Hash(user.getPassword()).toHex()).setCreateTime(LocalDateTime.now());
        int result = userMapper.insert(user);
        if (result > 0) {
            return Response.success("注册成功", user);
        } else {
            return Response.error(ResponseStatus.ERROR, user);
        }
    }

    /**
     * 用户登录功能
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    public User checkUser(String email, String password) {
        User user = userMapper.getByEmail(email);
        if (user == null) {
            throw new RRException("该用户不存在");
        }
        if (!user.getPassword().equals(new Sha256Hash(password).toHex())) {
            throw new RRException("用户密码错误");
        }
        return user;
    }

    /**
     * 执行登录逻辑
     * @param user
     * @return
     */
    public User doSign(User user) {
        try {
            user.setToken(TokenUtil.create(user.getId(), user.getPassword()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        redisTemplate.opsForValue().set("zhifou:user:token", user);
        return user;
    }

}
