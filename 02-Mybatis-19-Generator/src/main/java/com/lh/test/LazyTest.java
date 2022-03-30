package com.lh.test;

import com.lh.dao.StudentMapper;
import com.lh.entity.Student;
import com.lh.entity.StudentExample;
import com.lh.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class LazyTest {
    @Test
    public void test(){
        StudentMapper mapper = MyBatisUtils.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByExample(null);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void testAll(){
        StudentMapper mapper = MyBatisUtils.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByExampleWithBLOBs(null);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void testById(){
        StudentMapper mapper = MyBatisUtils.getMapper(StudentMapper.class);
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andGenderLike("嘀嘀嘀");
        List<Student> students = mapper.selectByExampleWithBLOBs(example);
        for (Student student : students) {
            System.out.println(student);

        }

    }
}
