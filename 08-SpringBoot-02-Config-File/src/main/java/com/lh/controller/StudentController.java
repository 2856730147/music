package com.lh.controller;

import com.lh.entlity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("student")
public class StudentController {
    @Value("${student.name}")
    private  String name;
    @Value("${student.age}")
    private  Integer age;
    @Value("${student.gender}")
    private  String gender;
    @Value("${student.married}")
    private  Boolean married;
    @Value("${student.birthday}")
    private  Date birthday;
    @Value("${student.info:说如果}")
    private  String info;

    @Autowired
    private Student student;

    @RequestMapping("getStudent")
    private  Student getStudent(){
        return student;
    }


@RequestMapping("getName")
    public String getName(){
        System.out.println(name+":"+age+":"+gender+":"+married+":"+birthday);
        return name+":"+age+":"+gender+":"+married+":"+birthday+":"+info;
    }


}

