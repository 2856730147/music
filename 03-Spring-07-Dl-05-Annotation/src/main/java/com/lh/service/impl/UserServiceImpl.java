package com.lh.service.impl;

import com.lh.dao.UserDao;
import com.lh.entity.User;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
//    根据数据类型进行注入
//    @Autowired
//    在数据类型相同下的情况，再根据id进行注入
//    @Qualifier("userDaoMysql"
    //即根据类型又匹配id
    @Resource(name="userDaoMysql")
    private UserDao userDao;


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
