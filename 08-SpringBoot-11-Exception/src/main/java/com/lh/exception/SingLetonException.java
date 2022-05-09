package com.lh.exception;
//自定义单身狗异常
public class SingLetonException extends Exception {
    public SingLetonException(){
        super();
    }
    public SingLetonException(String message){
        super(message);
    }

}
