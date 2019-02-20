package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.common.Response;
import com.xiongzehua.zhifou.dao.ProblemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 问题操作
 * @author xiongzehua
 * @date 2019/2/15 15:38:49
 */

@Service
public class ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    public Response listPage() {
        return Response.success(problemMapper.listPage());
    }

}
