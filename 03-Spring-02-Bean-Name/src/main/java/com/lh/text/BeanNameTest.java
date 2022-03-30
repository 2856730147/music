package com.lh.text;

import com.lh.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanNameTest {
    @Test
    public void test() {
         ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student bean = context.getBean("student",Student.class);
        System.out.println(bean );

    }
}
