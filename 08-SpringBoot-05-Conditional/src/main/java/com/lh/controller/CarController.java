package com.lh.controller;

import com.lh.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @Autowired
    @Qualifier("car2")
    private Car car;

    @RequestMapping("getCar")
    public Car getCar(){
        return  car;
    }
}
