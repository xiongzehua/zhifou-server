package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.config.RedisConfig;
import com.xiongzehua.zhifou.dao.UserMapper;
import com.xiongzehua.zhifou.exception.RRException;
import com.xiongzehua.zhifou.pojo.User;
import com.xiongzehua.zhifou.util.TokenUtil;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;

    public User checkUser(String email, String password) {
        User user = userMapper.getByEmail(email);
        if (user == null) {
            throw new RRException("该用户不存在");
        }
        if (!user.getPassword().equals(new Sha256Hash(password).toHex())) {
            throw new RRException("密码错误");
        }
        return user;
    }

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
