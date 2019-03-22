package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.common.Response;
import com.xiongzehua.zhifou.dao.TalkMapper;
import com.xiongzehua.zhifou.pojo.Talk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TalkService {

    @Autowired
    private TalkMapper talkMapper;
    @Autowired
    RedisTemplate redisTemplate;

    public Integer createTalk(Talk talk) {
        talk.setCreateTime(LocalDateTime.now());
        return talkMapper.insert(talk);
    }

    public List<Talk> listTalkByTime() {
        List<Talk> talkList = talkMapper.listTalkByTime();
        return talkList;
    }

}
