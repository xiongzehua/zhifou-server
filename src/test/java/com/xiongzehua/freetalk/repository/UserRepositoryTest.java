package com.xiongzehua.freetalk.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

/**
 * Created by xiongzehua on 2019/6/19.
 */
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Test
    public void test1() {
        System.out.println(userRepository.);
    }

}