package com.lh.service.impl;

import com.lh.dao.StudentDao;
import com.lh.entity.Student;
import com.lh.service.StudentService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudebtServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public int insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public int update(Integer id,String info) {
        return studentDao.update(id,info);
    }

    @Override
    public int delete(Integer id) {
        return studentDao.delete(id);
    }
}
