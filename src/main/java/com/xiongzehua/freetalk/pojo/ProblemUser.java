package com.xiongzehua.freetalk.pojo;

import java.util.Date;
import lombok.Data;

/**
 * problem_user 实体类
 * 
 * @author : guomiaomiao
 * @date : 2019/02/23 16:49
 */
@Data
public class ProblemUser {
    /**
	 * id id
	 **/
    private Integer id;

    /**
	 * 问题id problem_id
	 **/
    private Integer problemId;

    /**
	 * 用户id user_id
	 **/
    private Integer userId;

    /**
	 * 是否点赞 like
	 **/
    private Boolean like;

    /**
	 * 是否收藏 collect
	 **/
    private Boolean collect;

    /**
	 * 是否评论 comment
	 **/
    private Boolean comment;

    /**
	 * 评论内容 content
	 **/
    private String content;

    /**
	 * 点赞时间 like_time
	 **/
    private Date likeTime;

    /**
	 * 收藏时间 collect_time
	 **/
    private Date collectTime;

    /**
	 * 评论时间 comment_time
	 **/
    private Date commentTime;

}