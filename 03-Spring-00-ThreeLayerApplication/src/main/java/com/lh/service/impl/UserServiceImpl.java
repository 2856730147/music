package com.lh.service.impl;

import com.lh.dao.UserDao;
import com.lh.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public void useDateBase() {
        userDao.useDateBase();
    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }


}
