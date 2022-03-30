package com.lh.demo02._static;

import org.junit.Test;

public class test {
    @Test
    public void test() {
        //真实对象
        GamePlay gamePlayProxy = new GamePlayer();
        //代练
        GamePlayProxy gamePlayProxy1 = new GamePlayProxy(gamePlayProxy);
        gamePlayProxy1.login();
        gamePlayProxy1.killBoss();
        gamePlayProxy1.upgrade();
    }
}
