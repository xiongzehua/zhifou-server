package com.xiongzehua.freetalk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "email")
    private String email;

    @TableField(value = "password")
    private String password;

    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "avatar_url")
    private String avatarUrl;

    @TableField(value = "sign_in_ip")
    private String signInIp;

    @TableField(value = "sign_in_time")
    private LocalDateTime signInTime;

    @TableField(value = "token")
    private String token;
}