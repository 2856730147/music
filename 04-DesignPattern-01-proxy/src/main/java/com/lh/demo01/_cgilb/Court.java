package com.lh.demo01._cgilb;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class Court {
    @Test
    public void test(){

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Parties.class);
        enhancer.setCallback(new LawOffice());
        Parties proxy = (Parties) enhancer.create(new Class[]{String.class},new Object[]{"晚宴"});
        proxy.submit();
        proxy.defend();


    }
}
