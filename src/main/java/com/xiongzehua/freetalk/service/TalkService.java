package com.xiongzehua.freetalk.service;

import com.xiongzehua.freetalk.dao.TalkMapper;
import com.xiongzehua.freetalk.dao.TalkPictureMapper;
import com.xiongzehua.freetalk.pojo.Talk;
import com.xiongzehua.freetalk.pojo.TalkPicture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class TalkService {

    @Autowired
    private TalkMapper talkMapper;
    @Autowired
    private TalkPictureMapper talkPictureMapper;
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 增加一条说说
     * @param talk 说说详情
     * @return
     */
    public Integer createTalk(Talk talk) {
        talk.setCreateTime(LocalDateTime.now());
        return talkMapper.insert(talk);
    }

    /**
     * 对说说按最新排序
     * @return
     */
    public List<Talk> listTalkByTime() {
        // TODO 点赞数 评论数 用户信息
        List<Talk> talkList = talkMapper.listTalkByTime();
        return talkList;
    }

    /**
     * 对说说按照热度（点赞数）排序
     * @return 结果列表
     */
    public List<Talk> listTalkByStar(Integer page) {
        // TODO 点赞数 评论数 用户信息
        Set<Integer> talkIds = redisTemplate.opsForZSet().range("talk:staredNumber", -(10*page), -(10*page-9));
        // TODO set好像是乱序的
        ArrayList<Integer> list = new ArrayList<>(talkIds);
        List<Talk> talkList = new ArrayList<>();
        for (int i = 9; i > -1; i--) {
            talkList.add(talkMapper.selectByPrimaryKey(list.get(i)));
        }
        return talkList;
    }

    /**
     * 上传图片
     */
    public Integer upload(MultipartFile file, Integer id) {
        if (!file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();  // 文件名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
                String filePath = "C://pic"; // 上传后的路径
                fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + fileName; // 新文件名
                File dest = new File(filePath);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                file.transferTo(dest);
                String filename = "/pic" + fileName;
                TalkPicture talkPicture = new TalkPicture().setTalkId(id).setPictureURL(filename);
                Talk talk = talkMapper.selectByPrimaryKey(id);
                int result = talkPictureMapper.insert(talkPicture);
                if (result > 0) {
                    talk.getTalkPictures().add(talkPicture);
                }
                talkMapper.updateByPrimaryKey(talk);
            } catch(IOException e) {
                log.info("文件上传异常");
                e.printStackTrace();
            }
        }
        return 0;
    }

}
