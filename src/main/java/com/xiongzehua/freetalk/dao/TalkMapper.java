package com.xiongzehua.freetalk.dao;

import com.xiongzehua.freetalk.entity.Talk;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TalkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Talk record);

    int insertSelective(Talk record);

    Talk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Talk record);

    int updateByPrimaryKey(Talk record);

    List<Talk> listTalkByTime();

}