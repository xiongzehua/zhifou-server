package com.xiongzehua.zhifou.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Talk {
    private Integer id;

    private String content;

    private Integer createId;

    private LocalDateTime createTime;

}