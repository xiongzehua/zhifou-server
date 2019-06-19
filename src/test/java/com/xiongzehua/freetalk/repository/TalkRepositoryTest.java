package com.xiongzehua.freetalk.repository;

import com.xiongzehua.freetalk.entity.Talk;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TalkRepositoryTest {

    @Autowired
    private TalkRepository talkRepository;

    @Test
    public void test1() {
        System.out.println(talkRepository.findAll());
    }

    @Test
    public void test2() {
        Talk talk = new Talk();
        talk.setUserId(1L).setCreateTime(LocalDateTime.now()).setUpdateTime(LocalDateTime.now()).setContent("第一条说说").setStarNumber(10).setCommentNumber(10);

        talkRepository.save(talk);
    }

    @Test
    public void test3() {
        talkRepository.findTalk("第一条说说");
    }

    /**
     * 分页
     */
    @Test
    public void test4() {
        Pageable pageable = PageRequest.of(1, 3, Sort.Direction.DESC, "content");
        System.out.println(talkRepository.findAll(pageable).getContent());
    }
}
