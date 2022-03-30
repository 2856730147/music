package com.lh.test;

import com.lh.dao.StudentDao;
import com.lh.pojo.Student;
import com.lh.utils.db;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MybatisTest {
    static Logger logger = Logger.getLogger(MybatisTest.class);
    @Test
    public void select(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            logger.info("测试了select");
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> select = mapper.Select();
        for (Student student : select) {
            System.out.println(student);
        }
        sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testLog4j(){
        logger.info("输出了Log4j的info");
        logger.debug("输出了Log4j的debug");
        logger.error("输出了Log4j的error");
    }

    @Test
    public void testLimit() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession openSession = factory.openSession();
            StudentDao mapper = openSession.getMapper(StudentDao.class);
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("no",0);
            map.put("size",2);
            List<Student> students = mapper.testLimit(map);
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void  textSelect(){
        SqlSession sqlSession = db.gitSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> select = mapper.select();
        for (Student student : select) {
            System.out.println(student);
        }
    }
}
