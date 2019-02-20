package com.xiongzehua.zhifou.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 问题实体类
 * @author xiongzehua
 * @date 2019/2/15 15:38:49
 */

@Data
@Accessors(chain = true)
public class Problem implements Serializable {
    private Integer id;

    private String title;

    private Integer userId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String content;
}