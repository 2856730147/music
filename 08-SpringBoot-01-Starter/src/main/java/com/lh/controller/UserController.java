package com.lh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@RequestMapping("hello")
    public  String hello(){
        return "亲爱的去";
    }
}
