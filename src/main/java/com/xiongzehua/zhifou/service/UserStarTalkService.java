package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.config.RedisConfig;
import com.xiongzehua.zhifou.pojo.Talk;
import com.xiongzehua.zhifou.pojo.UserStarTalk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserStarTalkService {

    public final static String TALK = "talk";

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisConfig redisConfig;

    /**
     * 对说说进行点赞
     * @param userStarTalk 点赞详情
     * @return
     */
    public void createUserStarTalk(UserStarTalk userStarTalk) {
        Integer userId = userStarTalk.getUserId();
        Integer talkId = userStarTalk.getTalkId();
        if (redisTemplate.opsForSet().isMember("talk:" + talkId + ":staredBy", userId)) {
            redisTemplate.opsForSet().remove("talk:" + talkId + ":staredBy", userId);
            // TODO 写数据库
        } else {
            redisTemplate.opsForSet().add("talk:" + talkId + ":staredBy", userId);
            // TODO 写数据库
        }
        redisTemplate.opsForZSet().add("talk:staredNumber", talkId, redisTemplate.opsForSet().size("talk:" + talkId + ":staredBy"));
    }

}
