package com.lh.dao.impl;

import com.lh.dao.UserDao;

public class UserDaoMySQLImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("使用mysql数据库");
    }
}
