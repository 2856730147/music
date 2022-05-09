package com.lh;

import com.lh.entity.Car;
import com.lh.entity.GirIFriend;
import com.lh.entity.Son;
import com.lh.entity.Wife;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        if (context.containsBean("girIFriend")){
            GirIFriend bean = context.getBean(GirIFriend.class);
            System.out.println("有对象"+bean);
        }else {
            System.out.println("没对象");
        }
        if (context.containsBean("son")){
            Son son = context.getBean(Son.class);
            System.out.println("有孩子"+son);
        }else {
            System.out.println("没孩子");
        }
        if (context.containsBean("wife")){
            Wife wife = context.getBean(Wife.class);
            System.out.println("有老婆"+wife);
        }else {
            System.out.println("没老婆");
        }
        Car car = context.getBean("car2",Car.class);
        System.out.println(car);

    }

}
