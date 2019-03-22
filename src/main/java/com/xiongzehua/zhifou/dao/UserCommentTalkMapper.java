package com.xiongzehua.zhifou.dao;

import com.xiongzehua.zhifou.pojo.UserCommentTalk;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserCommentTalkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCommentTalk record);

    int insertSelective(UserCommentTalk record);

    UserCommentTalk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCommentTalk record);

    int updateByPrimaryKey(UserCommentTalk record);
}