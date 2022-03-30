package com.lh.demo02._static;

public class GamePlayProxy implements GamePlay{
    private  final  GamePlay player;

    public GamePlayProxy(GamePlay player) {
        this.player = player;
    }

    @Override
    public void login() {
        this.verify();
        player.login();
    }

    @Override
    public void killBoss() {
        player.killBoss();
        this.addMoney();
    }

    @Override
    public void upgrade() {
        player.upgrade();
    }
    private void  verify(){
        System.out.println("请输入验证码");
    }
    private void  addMoney(){
        System.out.println("掉了一堆金币");
    }

}
