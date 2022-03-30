package com.lh.dao;

import com.lh.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
        //增
    int addStudent(Student student);
        //删
    int deleteStudent(@Param("id") Integer id);
        //改
    int updateStudent(Student student);
        //多行查询
    List<Student> insertAllStudent();
        //单行查询
    Student insertStudent(@Param("id") Integer id);
        //模糊查询
    List<Student> likeStudent(@Param("name") String name);
        //主键回填
        int getIncrement(Student student);
}
