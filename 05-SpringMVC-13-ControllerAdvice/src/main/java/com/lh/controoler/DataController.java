package com.lh.controoler;

import com.lh.entity.Student;
import com.lh.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("data")
public class DataController {
    @RequestMapping("getDate")
    public void getData(Date data){
        System.out.println(data);
    }
@RequestMapping("getName")
@ResponseBody
    public Map<String, Object>  getName(Student student, Teacher teacher){
   Map<String, Object> map = new HashMap<>();
    map.put("student",student);
    map.put("teacher",teacher);

    return map;
}
}
