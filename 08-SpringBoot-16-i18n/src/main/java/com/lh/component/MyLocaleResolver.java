package com.lh.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//自定义国际化解析器
//@Controller("localeResolver")
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取前端想要切换的语言
        String lang = request.getParameter("lang");
        Locale locale=null;
        if(lang !=null && !lang.equals("")){
            String[] array= lang.split("_");
           locale = new Locale(array[0], array[1]);
        }else {
            new Locale("en","US");
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
