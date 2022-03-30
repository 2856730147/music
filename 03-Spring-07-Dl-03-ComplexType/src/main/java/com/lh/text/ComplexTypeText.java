package com.lh.text;

import com.lh.entity.ComplexType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComplexTypeText {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ComplexType bean = context.getBean(ComplexType.class);
        System.out.println(bean);
    }
}
