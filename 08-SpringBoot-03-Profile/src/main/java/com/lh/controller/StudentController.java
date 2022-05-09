package com.lh.controller;

import com.lh.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private Student student;

    @RequestMapping("getStudent")
    public Student getStudent(){
        return student;
    }




    @RequestMapping("hello")
    public  String hello(){
        return "烤猪蹄";
    }
}
