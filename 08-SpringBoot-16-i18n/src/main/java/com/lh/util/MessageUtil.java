package com.lh.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;

import java.util.Locale;

//目前没有使用模板引擎，所以稍微一点麻烦
@Controller
public class MessageUtil {
    //说明一个消息资源对象
    private static  MessageSource messageSource;
    //初始化
    public  MessageUtil(MessageSource messageSource){
        MessageUtil.messageSource=messageSource;
    }
    public static String get(String msgKey){

        return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());

    }








}
