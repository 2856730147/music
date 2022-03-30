package com.lh.controller;

import com.lh.entity.User;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class UserConroller {
    //自动装配,会从容器找到对应的数据类型，进行注入
   @Autowired
    private UserService userService;
    public List<User> findAll(){
        return userService.findAll();
    }

}
