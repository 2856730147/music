package com.lh.demo01._jdk;

public class Parties implements Lawsuit {

    @Override
    public void submit() {
        System.out.println("饭店倒闭了");
    }

    @Override
    public void defend() {
        System.out.println("发我工资");
    }
}
