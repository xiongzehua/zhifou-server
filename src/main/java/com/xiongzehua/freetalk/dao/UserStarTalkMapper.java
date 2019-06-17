package com.xiongzehua.freetalk.dao;

import com.xiongzehua.freetalk.pojo.UserStarTalk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserStarTalkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserStarTalk record);

    int insertSelective(UserStarTalk record);

    UserStarTalk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserStarTalk record);

    int updateByPrimaryKey(UserStarTalk record);

    int deleteByTalkIdAndUserId(@Param("talkId") Integer talkId, @Param("userId") Integer userId);
}