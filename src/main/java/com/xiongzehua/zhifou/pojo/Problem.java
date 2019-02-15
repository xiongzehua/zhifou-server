package com.xiongzehua.zhifou.pojo;

import java.time.LocalDateTime;

public class Problem {
    private Integer id;

    private String title;

    private Integer userId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String content;

    public Problem(Integer id, String title, Integer userId, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Problem(Integer id, String title, Integer userId, LocalDateTime createTime, LocalDateTime updateTime, String content) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
    }

    public Problem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}