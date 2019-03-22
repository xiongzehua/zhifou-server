package com.xiongzehua.zhifou.service;

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

    /**
     * 增加一条说说
     * @param talk 说说详情
     * @return
     */
    public Integer createTalk(Talk talk) {
        talk.setCreateTime(LocalDateTime.now());
        return talkMapper.insert(talk);
    }

    /**
     * 对说说按照时间排序
     * @return
     */
    public List<Talk> listTalkByTime() {
        List<Talk> talkList = talkMapper.listTalkByTime();
        return talkList;
    }

}
