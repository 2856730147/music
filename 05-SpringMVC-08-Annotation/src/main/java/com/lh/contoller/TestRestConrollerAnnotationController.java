package com.lh.contoller;

import com.lh.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("controller")
public class TestRestConrollerAnnotationController {
    @RequestMapping("getUser")
    public User testUser(){
        return new User("易烊千玺",22,"男",new Date(),"无情的");
    }
}
