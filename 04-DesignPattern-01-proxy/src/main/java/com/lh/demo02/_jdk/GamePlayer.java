package com.lh.demo02._jdk;

public class GamePlayer implements GamePlay {
    @Override
    public void login() {
        System.out.println("登录");
    }

    @Override
    public void killBoss() {
        System.out.println("一刀999");
    }

    @Override
    public void upgrade() {
        System.out.println("升级了");
    }
}
