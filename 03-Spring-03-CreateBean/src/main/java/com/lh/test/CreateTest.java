package com.lh.test;

import com.lh.entity.Student;
import com.lh.factory.StudentFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateTest {
    @Test
    public void  test(){
        //获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        Student bean = context.getBean("student",Student.class);
        System.out.println(bean);
    }
    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student2 = context.getBean("student2", Student.class);
        System.out.println(student2);
    }
    @Test
    public void test3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = context.getBean("student3",Student.class);
        System.out.println(bean);
    }
}
