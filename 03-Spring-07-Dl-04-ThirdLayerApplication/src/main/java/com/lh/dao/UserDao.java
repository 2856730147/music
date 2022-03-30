package com.lh.dao;

import com.lh.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
