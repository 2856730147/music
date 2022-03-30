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

public class MybaTest {
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

}
