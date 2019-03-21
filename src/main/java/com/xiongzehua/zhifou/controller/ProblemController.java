package com.xiongzehua.zhifou.controller;

import com.xiongzehua.zhifou.common.Response;
import com.xiongzehua.zhifou.pojo.Talk;
import com.xiongzehua.zhifou.service.ProblemService;
import com.xiongzehua.zhifou.util.PageInfo;
import com.xiongzehua.zhifou.util.PageQuery;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

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
    @PostMapping(value = "/listPage")
    public Response listPage(@RequestParam HashMap<String, Object> pageParam,
                             @RequestBody(required = false) HashMap<String, Object> queryParam) {
        PageInfo<Talk> problemPageInfo = new PageInfo<>(problemService.listPage(PageQuery.build(pageParam, queryParam)));
        return Response.success(problemPageInfo);
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
     * @param talk 问题详情(主题与内容)
     * @return
     */
    @PostMapping(value = "/addProblem")
    public Response addProblem(@RequestBody Talk talk) {
        return Response.success(problemService.addProblem(talk));
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
     * @param talk 修改问题的属性
     * @return
     */
    @PostMapping("/updateOneProblem")
    public Response updateOneProblem(@RequestBody Talk talk) {
        return Response.success(problemService.updateOneProblem(talk));
    }


}
