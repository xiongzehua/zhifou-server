package com.xiongzehua.zhifou.pojo;

import java.time.LocalDateTime;

public class Relation {
    private Integer id;

    private Integer subjectId;

    private Integer objectId;

    private Boolean isDeleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Relation(Integer id, Integer subjectId, Integer objectId, Boolean isDeleted, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.subjectId = subjectId;
        this.objectId = objectId;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Relation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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
}