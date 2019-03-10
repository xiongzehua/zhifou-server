package com.xiongzehua.zhifou.service;

import com.xiongzehua.zhifou.common.BusinessStatus;
import com.xiongzehua.zhifou.dao.ProblemMapper;
import com.xiongzehua.zhifou.exception.BusinessException;
import com.xiongzehua.zhifou.pojo.Problem;
import com.xiongzehua.zhifou.util.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;


/**
 * 问题操作
 * @author xiongzehua
 * @date 2019/2/15 15:38:49
 */

@Service
public class ProblemService  {
    @Autowired UserService userService;

    @Autowired
    private ProblemMapper problemMapper;

    public List<Problem> listPage(PageQuery pageQuery) {
        return problemMapper.listPage(pageQuery);
    }

    public Problem getOneProblem(Integer id) {
        Problem problem = problemMapper.selectByPrimaryKey(id);
        if (null == problem) {
            throw new BusinessException(BusinessStatus.GET_FAILURE);
        } else {
            return problem;
        }
    }

    public Problem addProblem(Problem problem) {
        problem.setUserId(1).setCreateTime(LocalDateTime.now());
        int result = problemMapper.insert(problem);
        if (result < 1) {
            throw new BusinessException(BusinessStatus.ADD_FAILURE);
        }
        return problem;
    }

    public Problem deleteOneProblem(Integer id) {
        Problem problem = problemMapper.selectByPrimaryKey(id);
        int result = problemMapper.deleteByPrimaryKey(id);
        if (result < 1) {
            throw new BusinessException(BusinessStatus.DELETE_FAILUER);
        }
        return problem;
    }

    public Problem updateOneProblem(Problem problem) {
        problem.setUpdateTime(LocalDateTime.now());
        int result = problemMapper.updateByPrimaryKeySelective(problem);
        if (result < 1) {
            throw new BusinessException(BusinessStatus.UPDATE_FAILURE);
        } else {
            return problem;
        }
    }

    public String getToken(HttpServletRequest request) {
        return request.getHeader("token");
    }

}
