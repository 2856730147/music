package com.lh.controller;

import org.springframework.web.servlet.HandlerInterceptor;

public class CrossInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Headers","*");
        response.setHeader("Access-Control-Allow-Methods","DELETE,GET,POST,PUT,OPTIONS");
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Max-Age","3600");
        response.setHeader("Access-Control-Allow-Credentials","true");
        return false;
    }
}
