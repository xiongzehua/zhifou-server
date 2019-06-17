package com.xiongzehua.freetalk.service;

import com.xiongzehua.freetalk.common.BusinessStatus;
import com.xiongzehua.freetalk.dao.ProblemMapper;
import com.xiongzehua.freetalk.exception.BusinessException;
import com.xiongzehua.freetalk.pojo.Talk;
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

    public List<Talk> listPage() {
        return problemMapper.listPage();
    }

    public Talk getOneProblem(Integer id) {
        Talk talk = problemMapper.selectByPrimaryKey(id);
        if (null == talk) {
            throw new BusinessException(BusinessStatus.GET_FAILURE);
        } else {
            return talk;
        }
    }

    public Talk addProblem(Talk talk) {
//        talk.setUserId((int)TokenUtil.getSub(null)).setCreateTime(LocalDateTime.now());
        int result = problemMapper.insert(talk);
        if (result < 1) {
            throw new BusinessException(BusinessStatus.ADD_FAILURE);
        }
        return talk;
    }

    public Talk deleteOneProblem(Integer id) {
        Talk talk = problemMapper.selectByPrimaryKey(id);
        int result = problemMapper.deleteByPrimaryKey(id);
        if (result < 1) {
            throw new BusinessException(BusinessStatus.DELETE_FAILUER);
        }
        return talk;
    }

    public Talk updateOneProblem(Talk talk) {
        talk.setUpdateTime(LocalDateTime.now());
        int result = problemMapper.updateByPrimaryKeySelective(talk);
        if (result < 1) {
            throw new BusinessException(BusinessStatus.UPDATE_FAILURE);
        } else {
            return talk;
        }
    }

    public String getToken(HttpServletRequest request) {
        return request.getHeader("token");
    }

}
