package com.lh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {
    @RequestMapping("text")
    public String text(){
        return "大门";
    }
}
