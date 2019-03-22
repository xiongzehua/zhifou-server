package com.xiongzehua.zhifou.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserStarTalk {
    private Integer id;

    private Integer talkId;

    private Integer createId;

    private LocalDateTime createTime;

}