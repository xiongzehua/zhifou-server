package com.xiongzehua.freetalk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户实体类
 * @author xiongzehua
 * @date 2019/2/15 15:38:49
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    private Long id;

    private String name;

    private String email;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


    private LocalDateTime updateTime;

    private String phone;

    private String avatarUrl;

    private String signInIp;

    private LocalDateTime signInTime;

    private String token;
}