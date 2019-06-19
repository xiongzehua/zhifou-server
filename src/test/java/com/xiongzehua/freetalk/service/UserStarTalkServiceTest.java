package com.xiongzehua.freetalk.service;

import com.xiongzehua.freetalk.entity.UserStarTalk;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserStarTalkServiceTest {

    @Autowired
    private UserStarTalkService userStarTalkService;

    public void createUserStarTalkTest() {
        UserStarTalk userStarTalk1 = new UserStarTalk().setUserId(1).setTalkId(4);
        userStarTalkService.createUserStarTalk(userStarTalk1);

        UserStarTalk userStarTalk2 = new UserStarTalk().setUserId(2).setTalkId(4);
        userStarTalkService.createUserStarTalk(userStarTalk2);

        UserStarTalk userStarTalk3 = new UserStarTalk().setUserId(3).setTalkId(4);
        userStarTalkService.createUserStarTalk(userStarTalk3);

        UserStarTalk userStarTalk4 = new UserStarTalk().setUserId(4).setTalkId(4);
        userStarTalkService.createUserStarTalk(userStarTalk4);

    }
}