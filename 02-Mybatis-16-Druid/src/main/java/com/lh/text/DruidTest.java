package com.lh.text;


import com.lh.dao.StudentDao;
import com.lh.entity.Student;
import com.lh.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class DruidTest {
@Test
    public void test(){
    StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
    List<Student> byId = mapper.findById();
    for (Student student : byId) {
        System.out.println(student);
    }
    MyBatisUtils.commit();
}
}
