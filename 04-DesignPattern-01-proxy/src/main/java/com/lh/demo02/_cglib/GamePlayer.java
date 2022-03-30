package com.lh.demo02._cglib;

import com.lh.demo02._jdk.GamePlay;

public class GamePlayer implements GamePlay {
    private final String username;

    public GamePlayer(String username) {
        this.username = username;
    }

    @Override
    public void login() {
        System.out.println(username+"登录");
    }

    @Override
    public void killBoss() {
        System.out.println(username+"一刀999");
    }

    @Override
    public void upgrade() {
        System.out.println(username+"升级了");
    }
}
