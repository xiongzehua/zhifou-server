package com.xiongzehua.freetalk.dao;

import com.xiongzehua.freetalk.entity.UserStarTalk;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStarTalkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserStarTalk record);

    int insertSelective(UserStarTalk record);

    UserStarTalk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserStarTalk record);

    int updateByPrimaryKey(UserStarTalk record);
}