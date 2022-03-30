package com.lh.contoller;

import com.lh.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("annotation")
public class AnnotationController {
    @RequestMapping("testRequestParam")
    public  String testRequestParam(@RequestParam(value = "userId",defaultValue = "3")  String id){
        System.out.println("获取参数"+id);
        return "/success.jsp";
    }
    @RequestMapping("page")
    public  String page(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize",defaultValue = "1") Integer pageSize){
        System.out.println("当前页"+pageNo+"每页显示多少"+pageSize);
        return "/success.jsp";
    }
    @RequestMapping("keyword")
    public  String keyword(@RequestParam(value = "name",defaultValue = "") String name,
                        @RequestParam(value = "gender",defaultValue = "") String gender){
        System.out.println("是否有这个姓名:"+name+"是否有年龄:"+gender);
        return "/success.jsp";
    }

    @GetMapping (value = "user/{id}")
    public String getUser(@PathVariable("id") Integer id){
        System.out.println("查询学生"+id);
        return "/success.jsp";
    }
    @DeleteMapping(value = "user/{id}")
    public String deletUser(@PathVariable(value = "id") Integer id ){
        System.out.println("删除学生"+id);
        return "/success.jsp";
    }
    @PostMapping(value = "user/{id}")
    public String updateUser(@PathVariable("id") Integer id){
        System.out.println("修改学生学生"+id);
        return "/success.jsp";
    }
    @PutMapping (value = "user/{id}" )
    public String addUser(@PathVariable("id") Integer id){

        System.out.println("添加学生"+id);
        return "/success.jsp";
    }
    @RequestMapping("testJson")
    public String  testJson(@RequestBody String json){
        System.out.println(json);
        return "/success.jsp";
    }

    @RequestMapping(value = "testJsonObject")
    public String  testJsonObject(@RequestBody User user){
        System.out.println(user);
        return "/success.jsp";
    }
}
