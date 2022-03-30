package com.lh.demo02._cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class GameOffice implements MethodInterceptor {
    //执行方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("login")){
            System.out.println("验证码登录");
        }
        Object invoke = methodProxy.invokeSuper(o, objects);
        if (method.getName().equals("killBoss")){
            System.out.println("爆了一地");
        }
        if (method.getName().equals("upgrade")){
            System.out.println("满级");
        }
        return invoke;
    }
}
