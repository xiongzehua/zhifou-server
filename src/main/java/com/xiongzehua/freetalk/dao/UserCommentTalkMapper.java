package com.xiongzehua.freetalk.dao;

import com.xiongzehua.freetalk.entity.UserCommentTalk;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCommentTalkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCommentTalk record);

    int insertSelective(UserCommentTalk record);

    UserCommentTalk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCommentTalk record);

    int updateByPrimaryKey(UserCommentTalk record);
}