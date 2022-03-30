package com.lh.text;

import com.lh.entity.Student;
import com.lh.entity.Teacher;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OlidSetText {
    static ApplicationContext context=null;
    @BeforeClass
    public static void  before(){
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        System.out.println("获取容器");
    }
    @AfterClass
    public static void  after(){
        ((ClassPathXmlApplicationContext)context).close();
        System.out.println("容器关闭");
    }
    @Test
    public void testSet(){
         Student student = context.getBean(Student.class);
        System.out.println(student);

        Teacher teacher = context.getBean(Teacher.class);
        System.out.println(teacher);
    }
    @Test
    public void testSet2(){
        Student student = context.getBean(Student.class);
        System.out.println(student);

        Teacher teacher = context.getBean(Teacher.class);
        System.out.println(teacher);
    }
    @Test
    public void testSet3(){
        Student student = context.getBean(Student.class);
        System.out.println(student);

        Teacher teacher = context.getBean(Teacher.class);
        System.out.println(teacher);
    }
}
