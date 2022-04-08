package com.lh.controller;

import com.lh.entity.User;
import com.lh.service.UserService;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

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
    public ResultVo update(){
        return null;
    }
}
