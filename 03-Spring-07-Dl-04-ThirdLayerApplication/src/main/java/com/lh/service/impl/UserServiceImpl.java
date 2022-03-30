package com.lh.service.impl;

import com.lh.dao.UserDao;
import com.lh.dao.impl.UserDaoImpl;
import com.lh.dao.impl.UserDaoMysqlImpl;
import com.lh.entity.User;
import com.lh.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
