package com.lh.controller;

import com.lh.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("fileUpload")
public class FileController {

    @PostMapping("form")
    public String formFileUpload(@RequestPart("face") MultipartFile face,
                                 @RequestPart("photo") MultipartFile[] photo) {
        // 单文件上传
        if (!face.isEmpty()) {
            FileUploadUtil.fileUpload(face);
        }

        // 多文件上传
        if (photo != null && photo.length > 0) {
            for (MultipartFile file : photo) {
                FileUploadUtil.fileUpload(file);
            }
        }

        return "redirect:/success.html";
    }
    @PostMapping("json")
    @ResponseBody
    public Map<String, Object> jsonUpload(@RequestPart("face") MultipartFile face,
                                 @RequestPart("photo") MultipartFile[] photo) {
       Map<String, Object> result = new HashMap<>();
        List<String> imgPaths = new ArrayList<>();

        // 单文件上传
        if (!face.isEmpty()) {
            String path = FileUploadUtil.fileUpload(face);
            imgPaths.add(path);
        }

        // 多文件上传
        if (photo != null && photo.length > 0) {
            for (MultipartFile file : photo) {
                String path = FileUploadUtil.fileUpload(file);
                imgPaths.add(path);
            }
        }

        result.put("message","上传成功");
        result.put("code",200);
        result.put("success",true);
        result.put("data",imgPaths);
        return result;
    }

}
