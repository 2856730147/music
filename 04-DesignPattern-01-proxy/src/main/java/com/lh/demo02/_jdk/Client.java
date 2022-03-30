package com.lh.demo02._jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    @Test
    public void test(){
        GamePlay player = new GamePlayer();

        InvocationHandler gameOffice = new GameOffice(player);

        GamePlay o = (GamePlay) Proxy.newProxyInstance(player.getClass().getClassLoader(), player.getClass().getInterfaces(), gameOffice);
        o.login();
        o.killBoss();
        o.upgrade();

    }
}
