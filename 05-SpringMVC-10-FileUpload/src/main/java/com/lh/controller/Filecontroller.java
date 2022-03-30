package com.lh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class Filecontroller {
    @RequestMapping("upload")
    public ModelAndView upload(MultipartFile upload, ModelAndView mv) {
//        必须是本地路径
        String path = "C:/Program Files/Java/apache-tomcat-8.5.37/webapps/upload/";

        //创建文件对象
        File file = new File(path);
        //如果路径不存在
        if (!file.exists()) {
//            创建多级路径
            file.mkdirs();
        }
//        获取文件名
        String originalFilename = upload.getOriginalFilename();

        try {
            if (originalFilename != null) {
//                上传
                upload.transferTo(new File(path, originalFilename));

                mv.addObject("img", originalFilename);

                mv.setViewName("/success.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mv;
    }


}
