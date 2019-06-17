package com.xiongzehua.freetalk.dao;

import com.xiongzehua.freetalk.entity.TalkPicture;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkPictureMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TalkPicture record);

    TalkPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TalkPicture record);
}
