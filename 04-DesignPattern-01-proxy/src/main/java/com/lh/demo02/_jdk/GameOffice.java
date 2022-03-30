package com.lh.demo02._jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GameOffice implements InvocationHandler {
    private  final Object target;

    public GameOffice(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("login")){
            System.out.println("请扫描登录");
        }

        Object invoke = method.invoke(target, args);
        if (method.getName().equals("killBoss")){
            System.out.println("爆了一地装备");
        }
        if (method.getName().equals("upgrade")){
            System.out.println("满级");
        }
        return invoke;
    }
}
