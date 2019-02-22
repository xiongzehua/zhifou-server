package com.xiongzehua.zhifou.dao;

import com.xiongzehua.zhifou.pojo.Problem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKeyWithBLOBs(Problem record);

    int updateByPrimaryKey(Problem record);

    List<Problem> listPage();
}