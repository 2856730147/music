package com.lh.text;


import com.lh.dao.StudentDao;
import com.lh.entity.Student;
import com.lh.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class StudentTest {
    @Test
    public void  selectAll(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        List<Student> students = mapper.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }
    @Test
    public void findByKeyword(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        List<Student> aNull = mapper.findByKeyword("%韩晨%", null);
        for (Student student : aNull) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }
    @Test
    public void findByStudent(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        List<Student> byStudent = mapper.findByStudent(null, null);
        for (Student student : byStudent) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }
    @Test
    public void findByStudentTirm(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        List<Student> byStudent = mapper.findByStudentTrim("%士%", 50);
        for (Student student : byStudent) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }
    @Test
    public  void Update(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(3);
        student.setName("马卡马卡");
        int update = mapper.Update(student);
        System.out.println(update);
        MyBatisUtils.commit();
    }
    @Test
    public  void UpdateTrim(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(3);
        student.setName("嘀嘀嘀");
        int update = mapper.Update(student);
        System.out.println(update);
        MyBatisUtils.commit();
    }
    @Test
    public void testDeleteMore(){
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
        int affectdRows = mapper.deleteMore(13,14,15,10);
        System.out.println(affectdRows);
        MyBatisUtils.commit();
    }
}
