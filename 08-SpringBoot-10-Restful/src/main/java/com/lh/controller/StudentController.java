package com.lh.controller;


import com.lh.entity.Student;
import com.lh.service.StudentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }
    @PostMapping("{name}/{age}/{gender}/{info}")
    public Integer insert(Student student){
        return studentService.insert(student);
    }
    @PutMapping("{info}/{id}")
    public Integer update(@PathVariable("info") String info,
                          @PathVariable("id") Integer id){
        return studentService.update(id,info);
    }
    @DeleteMapping("{id}")
    public Integer delete(@PathVariable("id") Integer id){
        return studentService.delete(id);
    }
    }
