package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.config.RedisConfig;
import com.xiongzehua.zhifou.dao.UserStarTalkMapper;
import com.xiongzehua.zhifou.pojo.Talk;
import com.xiongzehua.zhifou.pojo.UserStarTalk;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserStarTalkServiceTest {

    public final static String TALK = "talk";

    @Autowired
    private UserStarTalkMapper userStarTalkMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private UserStarTalkService userStarTalkService;

    @Test
    public void createUserStarTalkTest() {
        UserStarTalk userStarTalk = new UserStarTalk();
        userStarTalk.setTalkId(1);
        userStarTalk.setCreateId(2);
        userStarTalk.setCreateTime(LocalDateTime.now());
        userStarTalkService.createUserStarTalk(userStarTalk);
    }

    @Test
    public void listTalkByStarTest() {
        List<Talk> talkList = userStarTalkService.listTalkByStar(1, 10);
        for (Talk talk : talkList) {
            log.info(talk.toString());
        }
    }
}