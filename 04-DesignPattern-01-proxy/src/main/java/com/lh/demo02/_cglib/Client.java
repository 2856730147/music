package com.lh.demo02._cglib;

import com.lh.demo02._jdk.GamePlay;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class Client {
    @Test
    public void test(){
        Enhancer enhancer = new Enhancer();
       enhancer.setSuperclass(GamePlayer.class);
       enhancer.setCallback(new GameOffice());
        GamePlayer o = (GamePlayer) enhancer.create();
        o.login();
        o.killBoss();
        o.upgrade();
    }
}
