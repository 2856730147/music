package com.lh.dao.impl;

import com.lh.dao.UserDao;

public class UserMysqlImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("使用mysql");
    }
}
