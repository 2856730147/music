package com.lh.text;


import com.lh.dao.StudentDao;
import com.lh.entity.Student;
import com.lh.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class StudentTest {
    @Test
    public void testTwo(){
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("Mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            SqlSession sqlSession = build.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);

            System.out.println("第一次查询");
             mapper.findById(3);
            Student student = new Student();
            student.setId(3);
            student.setInfo("权威的");
            mapper.update(student);
            sqlSession.commit();
            System.out.println("第二次查询");
            mapper.findById(3);
            System.out.println("第三次查询");
            mapper.findById(3);
            System.out.println("第四次查询");
            mapper.findById(3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
  public void testStudentfindById(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            Student student1 = mapper.findById(3);
            //清除缓存
            Student student = new Student();
            student.setId(3);
            student.setInfo("死光光");
            mapper.update(student);
            sqlSession.rollback();
            Student student2 = mapper.findById(3);
        System.out.println(student1 == student2);

        MyBatisUtils.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testStudentUpdate(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            Student student = new Student();
            student.setInfo("分为无法");
            student.setId(3);
            int update = mapper.update(student);
            System.out.println(update);
            MyBatisUtils.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
