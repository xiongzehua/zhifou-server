package com.xiongzehua.zhifou.controller;

import com.xiongzehua.zhifou.common.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xiongzehua on 2019/3/23.
 */
@Controller
public class TalkController {

    @PostMapping
    public Response upload(MultipartFile file) {
        // TODO 调用service
        // TODO service里存在文件夹pic里
        // TODO sql里存文件名和talkid的映射关系 Picture类已经建立好了

        return Response.success();
    }
}
