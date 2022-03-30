package com.lh.demo01._jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LawOffice implements InvocationHandler {
    public final Object target;

    public LawOffice(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("submit")){
            System.out.println("收集证据");
        }
        if (method.getName().equals("defend")){
            System.out.println("交流意见");
        }
        Object invoke = method.invoke(target, args);
        return invoke;
    }
}
