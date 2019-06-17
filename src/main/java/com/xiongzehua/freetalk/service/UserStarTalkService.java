package com.xiongzehua.freetalk.service;

import com.xiongzehua.freetalk.dao.UserStarTalkMapper;
import com.xiongzehua.freetalk.pojo.UserStarTalk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserStarTalkService {

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
            // TODO 写数据库流水
            userStarTalkMapper.deleteByTalkIdAndUserId(talkId, userId);
        } else {
            redisTemplate.opsForSet().add("talk:" + talkId + ":staredBy", userId);
            // TODO 写数据库流水
            userStarTalk.setCreateTime(LocalDateTime.now());
            userStarTalkMapper.insert(userStarTalk);
        }
        redisTemplate.opsForZSet().add("talk:staredNumber", talkId, redisTemplate.opsForSet().size("talk:" + talkId + ":staredBy"));
    }

}
