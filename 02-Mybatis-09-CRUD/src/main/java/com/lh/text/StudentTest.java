package com.lh.text;

import com.lh.dao.StudentDao;
import com.lh.entity.Student;
import com.lh.utils.MyBatisUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class StudentTest {
    @Test
    public void addStudent(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("铠甲勇士");
        student.setAge((byte) 50);
        student.setGender("男");
        student.setBirthday(new Date());
        student.setInfo("炎龙侠");
        int i = mapper.addStudent(student);
        System.out.println(i);
        MyBatisUtils.commit();
    }
    @Test
    public void deleteStudent(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        int i = mapper.deleteStudent(2);
        System.out.println(i);
        MyBatisUtils.commit();
    }
    @Test
    public void updateStudent(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("马克马克");
        student.setId(3);
        int i = mapper.updateStudent(student);
        System.out.println(i);
        MyBatisUtils.commit();

    }
    @Test
    public void insertAllStudent(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        List<Student> students = mapper.insertAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }
    @Test
    public void insertStudent(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        Student student = mapper.insertStudent(1);
        System.out.println(student);
        MyBatisUtils.commit();
    }
    @Test
    public void likeStudent(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        List<Student> students = mapper.likeStudent("%时代%");
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }
    @Test
    public void getIncrement(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("铠甲勇士");
        student.setAge((byte) 50);
        student.setGender("男");
        student.setBirthday(new Date());
        student.setInfo("炎龙侠");
        int increment = mapper.getIncrement(student);
        System.out.println(increment);
        System.out.println(student.getId());
        MyBatisUtils.commit();


    }
}
