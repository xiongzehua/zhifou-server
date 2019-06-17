package com.xiongzehua.freetalk.controller;

import com.xiongzehua.freetalk.common.Response;
import com.xiongzehua.freetalk.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xiongzehua on 2019/3/23.
 */
@Controller
public class TalkController {

    @Autowired
    private TalkService talkService;

    @PostMapping(value = "/fileUpload")
    public Response upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id) {
        // TODO 调用service
        return Response.success(talkService.upload(file, id));
        // TODO service里存在文件夹pic里
        // TODO sql里存文件名和talkid的映射关系 Picture类已经建立好了
    }

}
