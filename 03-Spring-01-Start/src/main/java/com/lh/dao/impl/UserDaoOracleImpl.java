package com.lh.dao.impl;

import com.lh.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("使用oracle数据库");
    }
}
