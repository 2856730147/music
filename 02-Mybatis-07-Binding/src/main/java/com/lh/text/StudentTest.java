package com.lh.text;

import com.lh.dao.StudentDao;
import com.lh.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class StudentTest {
    @Test
    public void testSelect(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            Student select = mapper.Select();
            System.out.println(select);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testselectid(){
        try {
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            Student id = mapper.selectid(3, "哈巴");
            System.out.println(id);
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
    @Test
    public void testselectid1(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            Student id = mapper.selectid1(1, "黑暗时代");
            System.out.println(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testinsert(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            Student student = new Student();
            student.setName("时代");
            student.setAge((byte) 32);
            student.setGender("男");
            student.setInfo("韩晨晕");
            int insert = mapper.Insert(student);
            System.out.println(insert);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
