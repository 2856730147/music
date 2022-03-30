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
    public void testadd(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();
            int insert = sqlSession.insert("StudentMapper.add");
            System.out.println(insert);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelect(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession openSession = factory.openSession();
            Object o = openSession.selectOne("StudentMapper.Select");
            System.out.println(o);
            openSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Select(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession openSession = factory.openSession();
            StudentDao mapper = openSession.getMapper(StudentDao.class);
            Student select = mapper.Select();
            System.out.println(select);
            openSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Delete(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession openSession = factory.openSession();
            StudentDao mapper = openSession.getMapper(StudentDao.class);
            int delete = mapper.Delete();
            System.out.println("影响行数是"+delete);
            openSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
