package com.lh.Controller;

import com.lh.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LinkExpressionController {
    @RequestMapping("test/link/test")
    public String selectiveExpression(Model model){

        return "link";
}
    @RequestMapping("url")
    @ResponseBody
    public String testUrl(Model model){
        return "绝对路径";
    }
    @RequestMapping("/test/url")
    @ResponseBody
    public String testSuperUrl(Model model){
        return "上级路径";
    }

    @RequestMapping("/test/link/url")
    @ResponseBody
    public String testThisUrl(Model model){
        return "当前路径";
    }
}

