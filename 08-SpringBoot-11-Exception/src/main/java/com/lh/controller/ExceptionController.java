package com.lh.controller;

import com.lh.exception.SingLetonException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exception")
public class ExceptionController{

    @GetMapping("system")
    public  String testSystemException(){
        int num=1/0;
        return "没有问题";
    }
    @GetMapping("singleton")
    public  void testSingletonException() throws SingLetonException{
        throw new SingLetonException("单身狗异常");

    }
}
