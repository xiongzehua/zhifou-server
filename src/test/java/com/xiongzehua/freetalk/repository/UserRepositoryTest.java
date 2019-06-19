package com.xiongzehua.freetalk.repository;

import com.xiongzehua.freetalk.entity.User;
import com.xiongzehua.freetalk.utils.MapperUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * https://cloud.tencent.com/developer/article/1336309
 * http://www.iocoder.cn/Spring-Data-JPA/good-collection/?vip
 * Created by xiongzehua on 2019/6/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Test
    public void test1() {
        System.out.println(userRepository.findAll());
    }

    @Test
    public void test2() {
        User user = new User();
        user.setPassword(MapperUtils.stringToSHA256("123456")).setEmail("3133@qq.com").setName("d订单三").setPhone("11111").setCreateTime(LocalDateTime.now()).setUpdateTime(LocalDateTime.now());
        user.setPassword(MapperUtils.stringToSHA256("123456")).setEmail("3133@qq.com").setName("1三").setPhone("11111").setCreateTime(LocalDateTime.now()).setUpdateTime(LocalDateTime.now());
        user.setPassword(MapperUtils.stringToSHA256("123456")).setEmail("3133@qq.com").setName("66三").setPhone("11111").setCreateTime(LocalDateTime.now()).setUpdateTime(LocalDateTime.now());

        userRepository.save(user);
    }

    @Test
    public void test3() {
        User user = new User();
        userRepository.updatePhone(1L, "aaa");
    }

    /**
     * 分页
     */
    @Test
    public void test4() {
        Pageable pageable = PageRequest.of(1, 3, Sort.Direction.DESC, "name");
        System.out.println(userRepository.findAll(pageable).getContent());
    }

}