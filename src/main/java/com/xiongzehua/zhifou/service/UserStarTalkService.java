package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.config.RedisConfig;
import com.xiongzehua.zhifou.dao.UserStarTalkMapper;
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
    private UserStarTalkMapper userStarTalkMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisConfig redisConfig;

    public void createUserStarTalk(UserStarTalk userStarTalk) {
        Integer userId = userStarTalk.getTalkId();
        Integer talkId = userStarTalk.getTalkId();
        userStarTalk.setCreateTime(LocalDateTime.now());
        Set<Integer> userSet = (Set<Integer>)redisTemplate.opsForValue().get(talkId);
        if (!userSet.contains(userStarTalk.getCreateId())) {
            redisConfig.zadd(TALK, talkId, userSet.size()+1);
            userSet.add(userId);
        } else {
            this.cleanKeys(talkId.toString());
            redisConfig.zadd(TALK, talkId, userSet.size()-1);
        }
        redisTemplate.opsForValue().set(talkId, userSet);
    }

    public String cleanKeys(String key) {
        Set<String> keys = redisTemplate.keys(key);
        for (String k : keys) {
            redisTemplate.delete(k);
        }
        return keys.toString();
    }

    public List<Talk> listTalkByStar() {
        Set<Object> talkSet = redisConfig.zrevrangeWithScoresBytes(TALK, 1, 100);
        List<Talk> talkList = new ArrayList(talkSet);
        return talkList;
    }

}
