package com.lh.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
@Component
@Order(1)
public class SexFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤前,只要性别为女发");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤条件：有女人味");
    }
}
