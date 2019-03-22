package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.dao.UserStarTalkMapper;
import com.xiongzehua.zhifou.pojo.UserStarTalk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserStarTalkService {

    public final static String TALK = "talk";

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserStarTalkMapper userStarTalkMapper;

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
            // 写数据库
            userStarTalkMapper.deleteByTalkIdAndUserId(talkId, userId);
        } else {
            redisTemplate.opsForSet().add("talk:" + talkId + ":staredBy", userId);
            // 写数据库
            userStarTalk.setCreateTime(LocalDateTime.now());
            userStarTalkMapper.insert(userStarTalk);
        }
        redisTemplate.opsForZSet().add("talk:staredNumber", talkId, redisTemplate.opsForSet().size("talk:" + talkId + ":staredBy"));
    }

}
