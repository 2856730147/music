package com.lh.config;


import com.lh.entity.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("car")
    @ConditionalOnMissingBean({Bike.class, Car.class})
    @ConditionalOnBean(Person.class)
    public Car getCar(){
        Car car = new Car();
        car.setBrand("永久");
        return car;
    }
    @Bean("car2")
    public Car getCar2(){
        Car car = new Car();
        car.setBrand("寒冰");
        return car;
    }

    @Bean("wife")
    public Wife wife(){
        return new Wife();
    }
    @Bean("son")
//    如果容器中有Wife类的对象就注入Son
    @ConditionalOnBean(Wife.class)
    public Son son(){
        return new Son();
    }
    @Bean("girIFriend")
    //如果没有老婆就可以有女朋友
    @ConditionalOnBean(Wife.class)
    public GirIFriend girIFriend(){
        return new GirIFriend();
    }
}
