package com.lh.dao;

import com.lh.entity.Student;

import java.util.List;

//@Mapper
public interface StudentDao {
    List<Student> findAll();
}
