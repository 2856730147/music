package com.lh.service.impl;

import com.lh.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("添加学生");
    }

    @Override
    public void update() {
        System.out.println("修改了学生的信息");
    }
}
