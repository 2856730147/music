package com.lh.text;

import com.lh.controller.UserConroller;
import com.lh.dao.UserDao;
import com.lh.entity.User;
import com.lh.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserText {
    @Test
    public void test(){
        UserConroller userConroller = new UserConroller();
        List<User> all = userConroller.findAll();
        System.out.println(all);
    }
    @Test
    public void  textContext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user = context.getBean(User.class);
        UserConroller userConroller = context.getBean(UserConroller.class);
        UserService userService = context.getBean(UserService.class);

        System.out.println(user);
        System.out.println(userService);

        List<User> all = userConroller.findAll();
        System.out.println(all);

    }
}
