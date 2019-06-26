package com.xiongzehua.freetalk.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiongzehua.freetalk.entity.Talk;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

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

    // 简单条件查询可以使用wrapper，复杂的d多表才用mapper.xml
    @Test
    public void test1_1() {
        QueryWrapper condition = new QueryWrapper();
        condition.gt("star_number", 20);
        System.out.println(talkMapper.selectList(condition));
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

    @Test
    public void test4() {
        Talk talk = new Talk();
        talk.setContent("新的说说").setUserId(1L).setCreateTime(LocalDateTime.now()).setStarNumber(0).setCommentNumber(0).setUpdateTime(LocalDateTime.now());
        System.out.println(talkMapper.insert(talk));
    }


}