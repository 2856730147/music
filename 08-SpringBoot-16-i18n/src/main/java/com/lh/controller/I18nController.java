package com.lh.controller;

import com.lh.util.MessageUtil;
import com.lh.vo.LoginVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("i18n")
public class I18nController {
    @RequestMapping("get")
    private LoginVo get(){
        LoginVo loginVo = new LoginVo();
        loginVo.setLogin(MessageUtil.get("login"));
        loginVo.setWelcome(MessageUtil.get("welcome"));
        loginVo.setTitle(MessageUtil.get("title"));
        loginVo.setUsername(MessageUtil.get("username"));
        loginVo.setPassword(MessageUtil.get("password"));
        loginVo.setRememberMe(MessageUtil.get("rememberMe"));
        return loginVo;
    }
}
