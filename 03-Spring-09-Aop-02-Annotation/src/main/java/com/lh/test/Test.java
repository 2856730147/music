package com.lh.test;

import com.lh.advice.AnnotationAdvice;
import com.lh.config.AopConfig;
import com.lh.service.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void testAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        UserService bean = applicationContext.getBean(UserService.class);
        bean.add();
    }
   @org.junit.Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        userService.add();
        userService.update();
    }
}
