package com.xiongzehua.freetalk.service;

import com.xiongzehua.freetalk.common.BusinessStatus;
import com.xiongzehua.freetalk.exception.BusinessException;
import com.xiongzehua.freetalk.entity.User;
import com.xiongzehua.freetalk.utils.MapperUtils;
import com.xiongzehua.freetalk.utils.TokenUtil;
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
    RedisTemplate redisTemplate;

    /**
     * 用户注册功能
     * @param user 用户信息
     * @return
     */
    @Transactional
    public User signUp(User user) {
        if (null != null) {
            throw new BusinessException(BusinessStatus.ACCOUNT_EMAIL_USED);
        }
        user.setPassword(MapperUtils.stringToSHA256(user.getPassword()))
                .setCreateTime(LocalDateTime.now());
        return new User().setId(user.getId());
    }

    /**
     * 执行登录逻辑
     * @param user
     * @return
     */
    public User doSign(User user) {
        User user1 = null;
        if (user1 == null) {
            throw new BusinessException(BusinessStatus.ACCOUNT_NOt_EXIST);
        }
        if (!user1.getPassword().equals(MapperUtils.stringToSHA256(user.getPassword()))) {
            throw new BusinessException(BusinessStatus.ACCOUNT_WRONG_PASSWORD);
        }
        try {
            user.setToken(TokenUtil.create(user.getId(), user.getPassword()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        redisTemplate.opsForValue().set("freetalk:user:token", user);
        return user;
    }

    public User updateUser(User user) {
        user.setUpdateTime(LocalDateTime.now());
        int result = 0;
        if (result < 1) {
            throw new BusinessException(BusinessStatus.UPDATE_FAILURE);
        } else {
            return user;
        }
    }

    public User getUser(Integer id) {
        User user = null;
        if (null == user) {
            throw new BusinessException(BusinessStatus.GET_FAILURE);
        } else {
            return user;
        }
    }

}
