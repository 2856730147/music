package com.lh.test;

import com.lh.config.TxConfig;
import com.lh.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Propagate {
    @Test
    public void  test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        AccountService bean = context.getBean(AccountService.class);
        bean.addAccount("海绵宝宝","菠萝屋");

    }
}
