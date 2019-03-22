package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.pojo.Talk;
import com.xiongzehua.zhifou.pojo.UserStarTalk;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserStarTalkServiceTest {

    @Autowired
    private UserStarTalkService userStarTalkService;

    @Test
    public void createUserStarTalkTest() {
        UserStarTalk userStarTalk1 = new UserStarTalk().setUserId(1).setTalkId(1);
        userStarTalkService.createUserStarTalk(userStarTalk1);

        UserStarTalk userStarTalk2 = new UserStarTalk().setUserId(2).setTalkId(1);
        userStarTalkService.createUserStarTalk(userStarTalk2);
    }
}