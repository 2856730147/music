package com.lh.advice;

import com.lh.util.CustomFormatter;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class DataBindAvice {
//    所有的请求到达Controller之前都会执行这个方法
    @InitBinder
    public  void  parsDate(WebDataBinder webDataBinder){
        //添加自定义的格式化器
        webDataBinder.addCustomFormatter(new CustomFormatter());

    }
}
