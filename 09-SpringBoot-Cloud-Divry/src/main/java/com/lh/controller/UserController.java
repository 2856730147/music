package com.lh.controller;


import com.lh.entity.TbUser;
import com.lh.service.UserService;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("login")
    public ModelAndView userLogin(TbUser user, Integer remember, ModelAndView mv,
                                  HttpSession session,
                                  HttpServletResponse response){
       ResultVo resultVo= userService.login(user.getUsername(),user.getPassword());
        System.out.println(resultVo);
       if (resultVo.getCode()==0){
           //登录失败
           mv.addObject("resultInfo",resultVo);
           mv.setViewName("forward:/login.jsp");
       }else {
           session.setAttribute("user",resultVo.getData());
           if (remember != null && remember ==1){
               Cookie cookie = new Cookie("JSESSIONID", session.getId());
               cookie.setMaxAge(30*60);

               response.addCookie(cookie);

           }else {
               Cookie cookie = new Cookie("JSESSIONID", null);
               cookie.setMaxAge(-1);

               response.addCookie(cookie);
           }
           mv.setViewName("forward:/index/page");
       }

        return mv;
    }

    @GetMapping("logout")
    public ModelAndView logout(HttpSession session,HttpServletResponse response,ModelAndView mv){
        //重定向到登录页面
        Cookie cookie = new Cookie("JSESSIONID", null);
        //立即销毁cookie
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        //销毁session
        session.invalidate();

        mv.setViewName("redirect:/login.jsp");
        return mv;
    }
}