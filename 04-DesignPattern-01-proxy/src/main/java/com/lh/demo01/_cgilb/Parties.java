package com.lh.demo01._cgilb;

import com.lh.demo01._static.Lawsuit;

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
