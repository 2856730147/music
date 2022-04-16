package com.lh.controller;

import com.lh.entity.User;
import com.lh.service.FineUploadService;
import com.lh.vo.ResultVo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
    public class FileUploadController {
    @Autowired
    private FineUploadService fineUploadService;

    @RequestMapping("uploadImg")
    public ResultVo update(MultipartFile file,@RequestParam String type){

        return fineUploadService.fileUpload(file,type);

    }
    }
