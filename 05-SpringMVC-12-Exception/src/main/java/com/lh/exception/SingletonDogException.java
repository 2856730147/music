package com.lh.exception;
//自定义异常
public class SingletonDogException extends Exception{
    public SingletonDogException() {
    }

    public SingletonDogException(String message) {
        super(message);
    }
}
