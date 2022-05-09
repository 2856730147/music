package com.lh.Controller;

import com.lh.entity.Car;
import com.lh.entity.Person;
import com.lh.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("selective")
public class selectiveExpressionController {
    @RequestMapping("test")
    public String selectiveExpression(Model model){
    model.addAttribute("person",new Person(1,"易烊千玺",22));
        return "selective";
}
}
