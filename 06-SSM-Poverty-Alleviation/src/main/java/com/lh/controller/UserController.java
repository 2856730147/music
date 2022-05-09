package com.lh.controller;

import com.lh.entity.User;
import com.lh.service.UserService;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.sql.ResultSet;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("login")
    public ResultVo  login(@RequestParam  String username,
                           @RequestParam String password){
        return userService.login(username,password);
    }

//                       必须传递一个值，要不默认是defaultValue里的值
    @GetMapping("getlist")
    public ResultVo GetList(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "3")  Integer pageSize,
                            Long id){
      return userService.getList(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public  ResultVo add(@RequestBody User user){
        return userService.add(user);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody User user){
        return userService.update(user);
    }
    @GetMapping("delete")
    public  ResultVo delete(@RequestParam long id){
        return  userService.delete(id);
    }

}




