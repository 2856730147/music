package com.lh.text;


import com.lh.dao.DepantmentDao;
import com.lh.dao.EmployeeDao;
import com.lh.dao.StudentDao;
import com.lh.entity.Employee;
import com.lh.entity.Student;
import com.lh.utils.MyBatisUtils;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.List;

public class DruidTest {
@Test
public void testEmployee(){
    EmployeeDao mapper = MyBatisUtils.getMapper(EmployeeDao.class);
    List<Employee> byId = mapper.findById(3);
    for (Employee employee : byId) {
        System.out.println(employee);
    }
    MyBatisUtils.commit();
}
@Test
    public void testDepartment(){
    DepantmentDao mapper = MyBatisUtils.getMapper(DepantmentDao.class);
    DecimalFormat decimalFormat = mapper.dindById(3);
    System.out.println(decimalFormat);
    MyBatisUtils.commit();
}
}
