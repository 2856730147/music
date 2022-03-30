package com.lh.text;

import com.lh.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecyleTest {
@Test
    public void test(){
    ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    Student student = context.getBean("student", Student.class);
    System.out.println(student);
    ((ClassPathXmlApplicationContext) context).close();
}
}
