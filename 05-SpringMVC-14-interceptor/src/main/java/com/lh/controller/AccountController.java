package com.lh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("account")
public class AccountController {
    @RequestMapping("getFoods")
    public ModelAndView getFoods(ModelAndView mv){
        //模拟连接数据库操作...

        System.out.println("连接数据库操作...");
        List<Object> foods = new ArrayList<>();

        foods.add("烤牛肉");
        foods.add("烤羊肉");
        foods.add("烤猪肉");
        foods.add("烤肉");

        mv.addObject("foods",foods);

        mv.setViewName("/account/getFoods");

        return mv;
    }
}
