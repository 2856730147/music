package com.lh.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
//接口
@RequestMapping("user")
@Api(tags = "用户模块" ,description = "查询所有用户")
public class UserController {
    @ApiOperation(hidden = true ,value = "查询所有用户",tags = "select")
    @GetMapping("findAll")
    public  String findAll(){
        return "user findAll";
    }
    @ApiOperation(value = "根据id查询对应的用户",tags = "select")
    @GetMapping("findById")
    public String findById(@ApiParam(allowableValues = "range[1,5)",required = true ,hidden = true) @RequestParam(defaultValue = "1") Integer id){
        System.out.println("获取到的id"+id);
        return "user findById------"+id;
    }
    @ApiOperation(value = "分页查询用户",tags = "select")
    @GetMapping("findByPage")
    public String findByPage(@ApiParam(defaultValue = "分页参数：当前页",example = "1") @RequestParam(defaultValue = "1") Integer PageNum,
                             @ApiParam(defaultValue = "分页参数：每页显示多少页",example = "5") @RequestParam(defaultValue = "5") Integer PageSize){
        return "user findByPage"+PageNum+"每页显示："+PageSize;
    }
    @ApiOperation(value = "添加用户",tags = "operator")
    @PostMapping("add")
    public  String add(@ApiParam(name = "username",value = "用户名，必选")@RequestParam String username,
                       @ApiParam("用户密码，必选")@RequestParam String password){
        return "user add"+username+password;
    }
    @ApiOperation(value = "修改所有用户",tags = "operator")
    @PutMapping("Update")
    public  String Update(){
        return "user Update";
    }
    @ApiOperation(value = "删除所有用户",tags = "operator")
    @DeleteMapping("delete")
    public  String delete(){
        return "user delete";
    }

}
