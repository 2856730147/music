package com.lh.dao;


import com.lh.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao {
  @Select("select * from student")
  List<Student> findById();


}
