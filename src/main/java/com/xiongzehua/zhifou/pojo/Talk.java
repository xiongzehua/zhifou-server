package com.xiongzehua.zhifou.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 问题实体类
 * @author xiongzehua
 * @date 2019/2/15 15:38:49
 */

@Data
@Accessors(chain = true)
public class Talk implements Serializable {
    // mysql字段
    private Integer id;

    private Integer userId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String content;

    // 关联字段
    private User user;

    private List<TalkPicture> talkPictures; // TODO 要不要加缓存？ url缓存好做，图片缓存咋做？

    // redis字段
    private Integer staredNumber;

    private Integer commentedNumber;
}