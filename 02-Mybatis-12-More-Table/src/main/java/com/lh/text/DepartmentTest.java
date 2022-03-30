package com.lh.text;

import com.lh.dao.DepartmentDao;
import com.lh.dao.StudnetDao;
import com.lh.dao.SubjectDao;
import com.lh.entity.Department;
import com.lh.entity.Student;
import com.lh.entity.Subject;
import com.lh.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class DepartmentTest {
    @Test
    public void findAll(){
        DepartmentDao mapper = MyBatisUtils.getMapper(DepartmentDao.class);
        List<Department> all = mapper.findAll();
        for (Department department : all) {
            System.out.println(all);
        }
        MyBatisUtils.commit();
    }
    @Test
    public  void findAll1(){
        StudnetDao mapper = MyBatisUtils.getMapper(StudnetDao.class);
        List<Student> all = mapper.findAll();
        for (Student student : all) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }
    @Test
    public void  findAll2(){
        SubjectDao mapper = MyBatisUtils.getMapper(SubjectDao.class);
        List<Subject> subject = mapper.subject();
        for (Subject subject1 : subject) {
            System.out.println(subject1);
        }
        MyBatisUtils.commit();
    }
}
