package com.lh.test;

import com.lh.dao.impl.UserMysqlImpl;
import com.lh.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserTest {
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.useDateBase();
    }
    @Test
    public void testUser(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserMysqlImpl());
        userService.useDateBase();
    }

}
