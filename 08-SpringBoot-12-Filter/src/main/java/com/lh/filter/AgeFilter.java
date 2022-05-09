package com.lh.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.File;
import java.io.IOException;
import java.util.logging.LogRecord;
//@WebFilter("/*")
@Component
@Order(-1)
public class AgeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤条件前：要有钱的");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤条件后；很有钱");
    }
}
