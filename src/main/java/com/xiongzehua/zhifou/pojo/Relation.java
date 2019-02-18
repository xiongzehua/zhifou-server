package com.xiongzehua.zhifou.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Relation {
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    private Integer id;

    private Integer subjectId;

    private Integer objectId;

    private Boolean isDeleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}