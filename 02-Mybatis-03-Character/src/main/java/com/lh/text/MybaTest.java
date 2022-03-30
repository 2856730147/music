package com.lh.text;

import com.lh.dao.StudentDao;
import com.lh.entity.Student;
import com.lh.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybaTest {
    @Test
    public void testmax(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession openSession = factory.openSession();
            StudentDao mapper = openSession.getMapper(StudentDao.class);
            List<Student> max = mapper.max(2);
            for (Student user : max) {
                System.out.println(user);
            }
            openSession.commit();
            openSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void min(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            List<Student> students = mapper.min(30);

            for (Student student : students) {
                System.out.println(student);
            }
            sqlSession.commit();
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
