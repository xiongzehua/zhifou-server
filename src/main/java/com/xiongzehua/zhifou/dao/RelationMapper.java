package com.xiongzehua.zhifou.dao;

import com.xiongzehua.zhifou.pojo.Relation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Relation record);

    int insertSelective(Relation record);

    Relation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Relation record);

    int updateByPrimaryKey(Relation record);
}