package com.xiongzehua.zhifou.pojo;

import java.time.LocalDateTime;

public class User {
    private Integer id;

    private String name;

    private String email;

    private String password;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String avatarUrl;

    public User(Integer id, String name, String email, String password, LocalDateTime createTime, LocalDateTime updateTime, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.avatarUrl = avatarUrl;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }
}