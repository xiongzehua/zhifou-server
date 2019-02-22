package com.xiongzehua.zhifou.controller;

import com.xiongzehua.zhifou.common.Response;
import com.xiongzehua.zhifou.pojo.Problem;
import com.xiongzehua.zhifou.service.ProblemService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 问题
 * @author: guomiaomiao
 * @date 2019/2/15 15:38:49
 */
@Api(tags = "问题接口", description = "ProblemController")
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 请求问题列表
     * @return 返回问题列表
     */
    @GetMapping(value = "/listPage")
    public Response listPage() {
        return Response.success(problemService.listPage());
    }

    /**
     * 查询一个问题
     * @param id
     * @return
     */
    @GetMapping(value = "/getOneProblem/{id}")
    public Response getOneProblem(@PathVariable("id") Integer id) {
        return Response.success(problemService.getOneProblem(id));
    }

    /**
     * 增加一个问题
     * @param problem 问题详情(主题与内容)
     * @return
     */
    @PostMapping(value = "/addProblem")
    public Response addProblem(@RequestBody Problem problem) {
        return Response.success(problemService.addProblem(problem));
    }

    /**
     * 删除一个问题
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteOneProblem/{id}")
    public Response deleteOneProblem(@PathVariable("id") Integer id) {
        return Response.success(problemService.deleteOneProblem(id));
    }

    /**
     * 修改一个问题
     * @param problem 修改问题的属性
     * @return
     */
    @PostMapping("/updateOneProblem")
    public Response updateOneProblem(@RequestBody Problem problem) {
        return Response.success(problemService.updateOneProblem(problem));
    }


}
