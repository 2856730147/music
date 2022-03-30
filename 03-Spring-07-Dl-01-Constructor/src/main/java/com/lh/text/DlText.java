package com.lh.text;

import com.lh.entity.Car;
import com.lh.entity.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DlText {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Car car = context.getBean("car", Car.class);
        String s = car.toString();
        System.out.println(s);

        Person bean = context.getBean(Person.class);
        System.out.println(bean);

    }
}
