package com.xiongzehua.zhifou.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by xiongzehua on 2019/3/23.
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TalkPicture {
    private Integer id;

    private Integer talkId;

    private String pictureURL;
}
