package com.lh.entity;

public class Student {
    private Integer id;
    private String naem;
    private Byte age;

    public Student() {
        System.out.println("无参构造在执行");
    }
    public void  init(){
        System.out.println("初始化在执行");
    }
    public void  destroy(){
        System.out.println("销毁在执行");
    }
}
