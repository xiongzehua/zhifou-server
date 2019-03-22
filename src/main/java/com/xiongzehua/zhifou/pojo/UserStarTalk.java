package com.xiongzehua.zhifou.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class UserStarTalk {
    private Integer id;

    private Integer talkId;

    private Integer userId;

    private LocalDateTime createTime;

}