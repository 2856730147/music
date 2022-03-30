package com.lh.test;

import com.lh.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Springtest {
    @Test
    public void test() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.findAll();
    }
}
