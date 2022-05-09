package com.lh.config;

import com.lh.filter.AgeFilter;
import com.lh.filter.SexFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;
@Configuration
public class FilterConfig {
        @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        //设置过滤器到spring容器中，相当于加上了@Component注解
        bean.setFilter(new AgeFilter());
        //设置当前过滤器的优先级
        bean.setOrder(-1);
//        Collection<String> set = new ArrayList<>();
//        set.add("/test");
//        set.add("/login.html");
//        set.add("/*");
        bean.setUrlPatterns(Collections.singletonList("/*"));
//        bean.setUrlPatterns(set);
            return bean;
        }
    @Bean
    public FilterRegistrationBean<Filter> moeneyRegistrationBean() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        //设置过滤器到spring容器中，相当于加上了@Component注解
        bean.setFilter(new SexFilter());
        //设置当前过滤器的优先级
        bean.setOrder(1);
//        Collection<String> set = new ArrayList<>();
//        set.add("/test");
//        set.add("/login.html");
//        set.add("/*");
        bean.setUrlPatterns(Collections.singletonList("/login"));
//        bean.setUrlPatterns(set);
        return bean;
    }
}
