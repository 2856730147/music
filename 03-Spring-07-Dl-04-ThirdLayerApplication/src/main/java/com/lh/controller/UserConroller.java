package com.lh.controller;

import com.lh.entity.User;
import com.lh.service.UserService;
import com.lh.service.impl.UserServiceImpl;

import java.util.List;

public class UserConroller {
    private UserService userService;
    public List<User> findAll(){
        return userService.findAll();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
