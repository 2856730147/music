package com.lh.dao;

import com.lh.entity.Account;
import com.lh.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> employees();
    List<Account> account();
}
