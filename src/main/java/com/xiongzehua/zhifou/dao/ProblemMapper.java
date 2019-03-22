package com.xiongzehua.zhifou.dao;

import com.xiongzehua.zhifou.pojo.Talk;
import com.xiongzehua.zhifou.util.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Talk record);

    int insertSelective(Talk record);

    Talk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Talk record);

    int updateByPrimaryKeyWithBLOBs(Talk record);

    int updateByPrimaryKey(Talk record);

    List<Talk> listPage();
}