package com.lh.dao;

import com.lh.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> selectAll();
//模糊查询
    List<Student> findByKeyword(@Param("name")String name,@Param("age") Integer age);

    List<Student> findByStudent(@Param("name")String name,@Param("age") Integer age);
    //删除
    int Update(Student student);

    List<Student> findByStudentTrim(@Param("name")String name,@Param("age") Integer age);

    int UpdateTrim(Student student);
        //可变长参数 特点的参数可以单个或双个，底层是一个数组
    int deleteMore(Integer... ids);
}
