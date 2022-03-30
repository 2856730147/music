package com.lh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//将当前类注入到容器中
@Controller
//用于声明请求的url路径，和@WebServlet注解相同
@RequestMapping("user")
public class UserController {
    //方法上也能加载这个注解,相当二级路径
    @RequestMapping("login")
    public String  longin(){
        System.out.println("login");
        //如果需要页面跳转，必须通过根路径的方式，必须加/
        return "/login.jsp";
    }
    @RequestMapping("add")
    public String  add(){
        System.out.println("add");
        //如果需要页面跳转，必须通过根路径的方式，必须加/
        return "/success.jsp";
    }
    @RequestMapping("update")
    public String  update(){
        System.out.println("update");
        //如果需要页面跳转，必须通过根路径的方式，必须加/
        return "/success.jsp";
    }
}
