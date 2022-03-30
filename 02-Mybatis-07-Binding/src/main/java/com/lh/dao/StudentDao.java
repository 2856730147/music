package com.lh.dao;

import com.lh.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    Student Select();
    Student selectid(Integer id, String name);
    Student selectid1(@Param("id") Integer id,@Param("name") String name);
    int Insert(Student student);
}
