package com.lh.controoler;

import com.lh.exception.SingletonDogException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("exception")
public class ExceptionControoler {
    @RequestMapping("system")
    public  void  textSystem(){
        int num=1/0;
    }
    @RequestMapping("custom")
    public  void  textCustom() throws SingletonDogException {
      throw  new SingletonDogException();
    }
}
