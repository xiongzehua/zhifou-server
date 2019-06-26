package com.xiongzehua.freetalk.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiongzehua.freetalk.entity.Talk;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiongzehua
 * @date 2019-06-26 14:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TalkMapperTest {
    @Autowired
    TalkMapper talkMapper;

    @Test
    public void test1() {
        System.out.println(talkMapper.selectList(null));
    }

    @Test
    public void test2() {
        Talk talk = new Talk();
        talk.setContent("qqqq").setId(2L);
        System.out.println(talkMapper.updateById(talk));
    }
    @Test
    public void test3() {
        talkMapper.increaseStar(1L);
    }



}