package com.lh.dao.impl;

import com.lh.dao.UserDao;

public class UserImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("Hello Spring");
    }
}
