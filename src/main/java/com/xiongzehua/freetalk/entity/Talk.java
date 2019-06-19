package com.xiongzehua.freetalk.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
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
@Entity
@Table(name = "talk")
public class Talk implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "content")
    private String content;

    @Column(name = "star_number")
    private Integer starNumber;

    @Column(name = "comment_number")
    private Integer commentNumber;

    // 关联字段
    @Transient
    private User user;

    @Transient
    private List<TalkPicture> talkPictures; // TODO 要不要加缓存？ url缓存好做，图片缓存咋做？

}