package com.lh.test;

import com.lh.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserTest {
    @Test
    public void test(){

        UserDaoImpl userDao = new UserDaoImpl();
        userDao.fidAll();
    }

}
