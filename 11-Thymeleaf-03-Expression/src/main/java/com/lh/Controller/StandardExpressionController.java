package com.lh.Controller;

import com.lh.entity.Car;
import com.lh.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("standard")
public class StandardExpressionController {
    @RequestMapping("test")
    public String testStanderdExpression(Model model){
        model.addAttribute("name","易烊千玺");
        model.addAttribute("age",22);
        model.addAttribute("married",true);
        User user = new User(1, "马可波罗", 22, "带我去", "你好",new Car("比亚迪","白色"));
        model.addAttribute("user",user);
        return "standard";

    }
    @RequestMapping("test1")
    public String testStanderdExpression1(HttpSession session){
        session.setAttribute("name","易烊千玺");
        session.setAttribute("age",40);
        session.setAttribute("married",true);
        User user = new User(1, "马可波罗", 22, "带我访问去", "你好",new Car("比亚迪","白色"));
        session.setAttribute("user",user);
        return "standard";

    }
}
