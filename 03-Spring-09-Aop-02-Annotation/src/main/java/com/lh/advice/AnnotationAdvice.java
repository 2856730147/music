package com.lh.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//声明一个切面类
@Aspect
@Component
public class AnnotationAdvice {
    @Pointcut("execution(* com.lh.service.impl.*ServiceImpl.*(..))")
    public static void pointcut(){


    }
    @Before("AnnotationAdvice.pointcut()")
    public void before(){
        System.out.println("前置通知");
    }
    @AfterReturning("AnnotationAdvice.pointcut()")
    public void afterReturning(){
        System.out.println("后置通知");
    }
    @AfterThrowing("AnnotationAdvice.pointcut()")
    public void afterThrowing(){
        System.out.println("异常通知，发生异常执行");
    }
    @After("AnnotationAdvice.pointcut()")
    public void after(){
        System.out.println("最终通知，无论是否发生异常都执行");
    }
    @Around("AnnotationAdvice.pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕之前");
        //执行方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕之后");
        return proceed;
    }

}
