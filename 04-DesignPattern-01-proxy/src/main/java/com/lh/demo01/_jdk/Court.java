package com.lh.demo01._jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class Court {
    @Test
    public void test(){
        Lawsuit parties = new Parties();
        //获取律师事务所
        LawOffice lawOffice = new LawOffice(parties);

        Lawsuit o = (Lawsuit) Proxy.newProxyInstance(parties.getClass().getClassLoader(), parties.getClass().getInterfaces(), lawOffice);
        o.submit();
        o.defend();
    }
}
