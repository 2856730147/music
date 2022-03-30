package com.lh.dao.impl;

import com.lh.dao.UserDao;
import com.lh.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMysqlImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"大旗网大旗网","123234"));
        users.add(new User(1,"强无敌网球","123234"));
        users.add(new User(1,"权威的","23"));
        users.add(new User(1,"访问","123234"));
        return users;
        }
}
