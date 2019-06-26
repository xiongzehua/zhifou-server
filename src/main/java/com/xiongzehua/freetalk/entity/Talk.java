package com.xiongzehua.freetalk.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 问题实体类
 * @author xiongzehua
 * @date 2019-02-15 15:38:49
 */

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Talk implements Serializable {

    private Long id;

    @TableField(value = "userId")
    private Long userId;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    private String content;

    private Integer starNumber;

    private Integer commentNumber;

    // 关联字段
    @TableField(exist=false)
    private User user;

    @TableField(exist=false)
    private List<TalkPicture> talkPictures; // TODO 要不要加缓存？ url缓存好做，图片缓存咋做？

}