package com.lh.text;

import com.lh.dao.impl.JDBCTemplateDaoImpl;
import com.lh.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcText {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl bean = context.getBean(JDBCTemplateDaoImpl.class);
        System.out.println(bean);
    }
    @Test
    public void findAll(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl bean = context.getBean(JDBCTemplateDaoImpl.class);
        List<User> all = bean.findAll();
        System.out.println(all);
    }
    @Test
    public void findById(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl bean = context.getBean(JDBCTemplateDaoImpl.class);
        User all = bean.findById(2);
        System.out.println(all);
    }
    @Test
    public void findCount(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl bean = context.getBean(JDBCTemplateDaoImpl.class);
        int count = bean.findCount();
        System.out.println(count);
    }
    @Test
    public void findSelect(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl bean = context.getBean(JDBCTemplateDaoImpl.class);
        User user = new User();
        user.setUsername("四分卫");
        user.setPassword("1212212");
        int insert = bean.findInsert(user);
        System.out.println(insert);


    }
    @Test
    public void findUpdate(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl bean = context.getBean(JDBCTemplateDaoImpl.class);
        int aNull = bean.findupdated(new User(2, null, "232323"));
        System.out.println(aNull);
    }
    @Test
    public void findDelete(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl bean = context.getBean(JDBCTemplateDaoImpl.class);
        int delete = bean.findDelete(2);
        System.out.println(delete);
    }
}
