package com.lh.text;

import com.lh.entity.Student;
import com.lh.entity.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetText {
    @Test
    public void testSet(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student student = context.getBean(Student.class);
        System.out.println(student);

        Teacher teacher = context.getBean(Teacher.class);
        System.out.println(teacher);
    }
}
