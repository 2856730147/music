package com.lh.text;

import com.lh.controller.UserConroller;
import com.lh.entity.User;
import com.lh.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserText {
    @Test
    public void testIoc(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.lh");
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean);
    }
    @Test
    public void  textDl(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserConroller bean = context.getBean(UserConroller.class);
        List<User> all = bean.findAll();
        System.out.println(all);

    }
    @Test
    public void textValue(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User bean = context.getBean(User.class);
        context.close();
    }
}
