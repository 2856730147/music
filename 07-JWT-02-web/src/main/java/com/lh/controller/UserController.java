package com.lh.controller;

import com.lh.entity.User;
import com.lh.service.UserService;
import com.lh.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public Map<String, Object>login(User user){
    UserVo userVo = userService.login(user.getUsername(),user.getPassword());

        Map<String, Object> map = new HashMap<>();

        if (userVo !=null){
            map.put("Code",200);
            map.put("success",true);
            map.put("message","登陆成功");
            map.put("data",null);
        }else {
            map.put("Code",400);
            map.put("success",false);
            map.put("message","登录失败");
            map.put("data",null);
        }
        return map;
    }

}
