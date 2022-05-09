package com.lh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//注意，这里不能使用@RestController注解，因为当前我们必须使用视图解析器
//如果使用了@RestController注解将会跳过视图解析器
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
    @RequestMapping("test")
    public String text(HttpServletRequest request){
        //这是能识别出来，就没有波浪线了
        request.setAttribute("data","request请求域对象设置参数到thymeleaf中");
        return "index";
    }
    @RequestMapping("test1")
    public ModelAndView text1(ModelAndView mv){
        //这是能识别出来，就没有波浪线了
        mv.addObject("data","ModelAndView请求域对象设置参数到thymeleaf中");
        mv.setViewName("index");
        return mv;
    }

    //推荐使用Model加字符串跳转的方式
    @RequestMapping("test2")
    public String text2(Model model){
        //这是能识别出来，就没有波浪线了
       model.addAttribute("data","Model请求域对象设置参数到thymeleaf中");

        return "index";
    }














}
