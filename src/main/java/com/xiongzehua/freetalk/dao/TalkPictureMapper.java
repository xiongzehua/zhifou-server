package com.xiongzehua.freetalk.dao;

import com.xiongzehua.freetalk.pojo.TalkPicture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TalkPictureMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TalkPicture record);

    TalkPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TalkPicture record);
}
