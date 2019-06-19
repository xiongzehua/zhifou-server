package com.xiongzehua.freetalk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
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
@Entity()
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "phone")
    private String phone;

    @Transient
    private String avatarUrl;

    @Transient
    private String signInIp;

    @Transient
    private LocalDateTime signInTime;

    @Transient
    private String token;
}