package com.lh.dao;

import com.lh.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findById(@Param("id") Integer id);
}
