package com.lh.text;

import com.lh.config.JdbcConfig;
import com.lh.dao.impl.JDBCTemplateDaoImpl;
import com.lh.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateText {
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);
        JDBCTemplateDaoImpl bean = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        User byId = bean.findById(3);
        System.out.println(byId);
    }

}
