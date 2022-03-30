package com.lh.demo01._cgilb;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LawOffice implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("submit")){
            System.out.println("收集证据");
        }
        //使用代理执行真实对象中的代理
        Object o1 = methodProxy.invokeSuper(o, objects);
        if (method.getName().equals("defend")){
            System.out.println("交流");
        }
        return o1;
    }
}
