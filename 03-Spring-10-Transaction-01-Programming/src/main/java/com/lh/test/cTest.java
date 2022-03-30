package com.lh.test;

import com.lh.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class cTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService bean = context.getBean("programmingService",AccountService.class);
        bean.transfer(1,2,800L);


    }
}
