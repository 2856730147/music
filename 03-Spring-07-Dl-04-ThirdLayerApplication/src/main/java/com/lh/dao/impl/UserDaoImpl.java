package com.lh.dao.impl;

import com.lh.dao.UserDao;
import com.lh.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        //连接数据库
        ArrayList<User> user = new ArrayList<>();
        user.add(new User(1,"马克马克","123234"));
        user.add(new User(1,"我发的","123234"));
        user.add(new User(1,"阿斯顿","23"));
        user.add(new User(1,"青蛙大全","123234"));
        return user;
    }
}
