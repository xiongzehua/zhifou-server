package com.xiongzehua.freetalk.dao;

import com.xiongzehua.freetalk.pojo.ProblemUser;
import com.xiongzehua.freetalk.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * problem_user 持久化层
 * 
 * @author : guomiaomiao
 * @date : 2019/02/23 16:49
 */
@Repository
@Mapper
public interface ProblemUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    ProblemUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}