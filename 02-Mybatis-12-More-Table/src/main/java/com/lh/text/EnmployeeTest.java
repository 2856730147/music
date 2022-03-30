package com.lh.text;

import com.lh.dao.EmployeeDao;
import com.lh.entity.Account;
import com.lh.entity.Employee;
import com.lh.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class EnmployeeTest {
    @Test
    public void fidAllMap(){
        EmployeeDao mapper = MyBatisUtils.getMapper(EmployeeDao.class);
        List<Employee> employees = mapper.employees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        MyBatisUtils.commit();
    }
    @Test
    public  void account(){
         EmployeeDao mapper = MyBatisUtils.getMapper(EmployeeDao.class);
        List<Account> account = mapper.account();
        for (Account account1 : account) {
            System.out.println(account1);
        }
        MyBatisUtils.commit();
    }
}
