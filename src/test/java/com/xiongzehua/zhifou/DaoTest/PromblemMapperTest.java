package com.xiongzehua.zhifou.DaoTest;

import com.alibaba.druid.pool.DruidDataSource;
import com.xiongzehua.zhifou.dao.ProblemMapper;
import com.xiongzehua.zhifou.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * Created by xiongzehua on 2019/2/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PromblemMapperTest {
    @Autowired
    ProblemMapper problemMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){
        System.out.println(userMapper.selectByPrimaryKey(1));
        DataSource dataSource = new DruidDataSource();
    }
}
