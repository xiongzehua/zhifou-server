package com.xiongzehua.zhifou.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class User {
    /** 数据库字段 */
    private Integer id;

    private String name;

    private String email;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private String avatarUrl;

    /** 业务扩展 */
    private String signInIp;

    private LocalDateTime signInTime;

    private String token;
}