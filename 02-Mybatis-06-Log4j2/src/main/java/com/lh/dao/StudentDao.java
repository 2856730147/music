package com.lh.dao;

import com.lh.entity.Student;

import java.util.List;

public interface StudentDao {
    Student Select();
    int Delete();
    List<Student> max(Integer age);
    List<Student> min(Integer age);

}
