package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.pojo.Talk;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TalkServiceTest {

    @Autowired
    private TalkService talkService;

    @Test
    public void createTalkTest() {
        Talk talk = new Talk().setContent("第五篇微博").setUserId(2).setCreateTime(LocalDateTime.now());
        int result = talkService.createTalk(talk);
        log.info("result = " + result);
        log.info("talk = " + talk.toString());
    }

    @Test
    public void listTalkByTimeTest() {
        List<Talk> talkList = talkService.listTalkByTime();
        log.info("talkList.size() = " + talkList.size());
        for (Talk talk : talkList) {
            log.info("talk = " + talk.toString());
        }
    }

    @Test
    public void listTalkByStar() {
        List<Talk> listTalkByStar = talkService.listTalkByStar(1);
        for (Talk talk : listTalkByStar) {
            log.info("talk = " + talk.toString());
        }
    }
}