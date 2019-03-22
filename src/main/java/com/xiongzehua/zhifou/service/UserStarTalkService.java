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
        Integer userId = userStarTalk.getTalkId();
        Integer talkId = userStarTalk.getTalkId();
        userStarTalk.setCreateTime(LocalDateTime.now());
        Set<Integer> userSet = (Set<Integer>)redisTemplate.opsForValue().get(talkId);
        if (!userSet.contains(userStarTalk.getCreateId())) {
            redisConfig.zadd(TALK, talkId, userSet.size()+1);
            userSet.add(userId);
        } else {
            userSet.remove(userId);
            redisConfig.zadd(TALK, talkId, userSet.size()-1);
        }
        redisTemplate.opsForValue().set(talkId, userSet);
    }

    /**
     * 对说说按照热度（点赞数）排序
     * @param star 开始编号
     * @param end 结束编号
     * @return 结果列表
     */
    public List<Talk> listTalkByStar(Integer star, Integer end) {
        Set<Object> talkSet = redisConfig.zrevrangeWithScoresBytes(TALK, star, end);
        List<Talk> talkList = new ArrayList(talkSet);
        return talkList;
    }

}
