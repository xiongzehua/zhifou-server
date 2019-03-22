package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.dao.TalkMapper;
import com.xiongzehua.zhifou.pojo.Talk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
     * 对说说按最新排序
     * @return
     */
    public List<Talk> listTalkByTime() {
        List<Talk> talkList = talkMapper.listTalkByTime();
        return talkList;
    }

    /**
     * 对说说按照热度（点赞数）排序
     * @return 结果列表
     */
    public List<Talk> listTalkByStar() {
        ArrayList<Talk> list = new ArrayList<Talk>(10);
        Set<Integer> talkIds = redisTemplate.opsForZSet().range("talk:staredNumber", -10, -1);
        for (Integer id : talkIds) {
            // TODO 查数据库通过talkIds拿到talk
            // TODO 加入list
        }
        return list;
    }

}
