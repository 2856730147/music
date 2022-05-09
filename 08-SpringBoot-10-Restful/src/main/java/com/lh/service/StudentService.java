package com.lh.service;

import com.lh.entity.Student;
import org.apache.catalina.User;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    int insert(Student student);
    int update(Integer id,String info);

    int delete(Integer id);

}
