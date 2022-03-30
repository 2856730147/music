package com.lh.dao;

import com.lh.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Student> Select();
    List<Student> testLimit(Map<String, Integer> map);

     public List<Student> select();
}
