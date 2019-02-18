package com.xiongzehua.zhifou.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Problem {
    private Integer id;

    private String title;

    private Integer userId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String content;
}