package com.lh.test;

import com.lh.config.TxConfig;
import com.lh.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public void testAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

        AccountService bean = applicationContext.getBean(AccountService.class);
        bean.transfer(1,2,300L);
    }
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService bean = context.getBean("annotationService",AccountService.class);
        bean.transfer(1,2,100L);


    }
}
