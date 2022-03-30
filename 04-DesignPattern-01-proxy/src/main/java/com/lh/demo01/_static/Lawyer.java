package com.lh.demo01._static;

public class Lawyer implements Lawsuit{
    //代理类中包含一个被代理的对象
    private final Lawsuit  Parties;

    public Lawyer(Lawsuit parties) {

        Parties = parties;
    }

    @Override
    public void submit() {
        this.gatherEvidence();

        Parties.submit();
    }

    @Override
    public void defend() {
        Parties.defend();
        this.compareNotes();
    }
    private  void  gatherEvidence(){
        System.out.println("收集证据");
    }
    private  void  compareNotes(){
        System.out.println("讨论意见");
    }
}
