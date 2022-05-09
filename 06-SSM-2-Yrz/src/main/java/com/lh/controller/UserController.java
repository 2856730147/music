package com.lh.controller;


import com.lh.entity.TbUser;
import com.lh.service.UserService;
import com.lh.vo.ResultInfo;
import com.lh.vo.ResultVo;
import com.lh.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("login")
    public ModelAndView userLogin(TbUser user,Integer remember, ModelAndView mv){
       ResultVo resultVo= userService.login(user.getUsername(),user.getPassword());

       if (remember==0){
           //登录失败
           mv.addObject("resultInfo",resultVo);
           mv.setViewName("forward/login.jsp");
       }else {
           mv.setViewName("forward/index.jsp");
       }

        return mv;
    }


}