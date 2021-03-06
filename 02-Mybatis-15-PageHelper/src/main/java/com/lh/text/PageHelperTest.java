package com.lh.text;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.StudentDao;
import com.lh.entity.Student;
import com.lh.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class PageHelperTest {
   @Test
    public void test(){
       StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);
       //开启分页
       PageHelper.startPage(1,3);
       List<Student> byId = mapper.findById();
       PageInfo<Student> studentPageInfo = new PageInfo<>(byId);
       System.out.println(studentPageInfo);
   }
}
