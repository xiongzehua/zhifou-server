package com.xiongzehua.freetalk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiongzehua.freetalk.entity.Talk;
import org.springframework.stereotype.Repository;

/**
 * @author xiongzehua
 * @date 2019-06-26 14:44
 */
@Repository
public interface TalkMapper extends BaseMapper<Talk> {
    void increaseStar(Long talkId);
}
