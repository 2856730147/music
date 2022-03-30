package com.lh.dao;


import com.lh.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
  List<Student> findById();


}
