package com.lh.controller;

import com.lh.entity.User;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
    @RequestMapping("findById")
    public User findById(@RequestParam Integer id){
        return userService.findById(id);
    }
    @RequestMapping("findCount")
    public Map<String, Object> findCount(){
        HashMap<String, Object> map = new HashMap<>();
        Integer count = userService.findCount();
        if (count>0){
            map.put("code",200);
            map.put("massage","查询成功");
            map.put("success",true);
            map.put("count",232);
        }else {
            map.put("code",400);
            map.put("massage","查询失败");
            map.put("success",false);
            map.put("count",-212);
        }

        return map;
    }
    @RequestMapping("insert")
    public Map<String, Object> insert(User user){

        HashMap<String, Object> map = new HashMap<>();
        int insert = userService.insert(user);
        if (insert>0){
            map.put("code",200);
            map.put("massage","添加成功");
            map.put("success",true);
            map.put("count",232);
        }else {
            map.put("code",400);
            map.put("massage","添加失败");
            map.put("success",false);
            map.put("count",-212);
        }

        return map;
    }
    @RequestMapping("update")
    public Map<String, Object> update(User user){

        HashMap<String, Object> map = new HashMap<>();
        int update = userService.update(user);
        if (update>0){
            map.put("code",200);
            map.put("massage","修改成功");
            map.put("success",true);
            map.put("count",232);
        }else {
            map.put("code",400);
            map.put("massage","修改失败");
            map.put("success",false);
            map.put("count",-212);
        }

        return map;
    }
    @RequestMapping("delete")
    public Map<String, Object> delete(@RequestParam Integer id){

        HashMap<String, Object> map = new HashMap<>();
        int delete = userService.delete(id);
        if (delete>0){
            map.put("code",200);
            map.put("massage","删除成功");
            map.put("success",true);
            map.put("count",232);
        }else {
            map.put("code",400);
            map.put("massage","删除失败");
            map.put("success",false);
            map.put("count",-212);
        }

        return map;
    }

}
