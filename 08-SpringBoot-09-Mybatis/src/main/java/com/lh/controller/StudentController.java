package com.lh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.entity.Student;
import com.lh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }
    @RequestMapping("findByPage")
    public PageInfo<Student>  findByPage(@RequestParam(defaultValue = "1")Integer pageNum,
                                         @RequestParam(defaultValue = "3") Integer pageSize){
//        开启分页
        PageHelper.startPage(pageNum,pageSize);
        List<Student> all = studentService.findAll();


        return new PageInfo<>(all);
    }
}