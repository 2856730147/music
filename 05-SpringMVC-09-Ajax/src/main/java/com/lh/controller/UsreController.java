package com.lh.controller;

import com.lh.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UsreController {
    @RequestMapping("register")
    public Map<String, Object> register(User user){
        System.out.println(user);
        Map<String, Object> map = new HashMap<>();

        map.put("code",200);
        map.put("message","注册成功");
        map.put("success",true);
        map.put("data","华南师范大学");

        return map;
    }
    @RequestMapping("getJson")
    public Map<String, Object> getJson(@RequestBody User user){
        System.out.println(user);
        Map<String, Object> map = new HashMap<>();

        map.put("code",200);
        map.put("message","注册成功");
        map.put("success",true);
        map.put("data","华南师范大学");

        return map;
    }
}
