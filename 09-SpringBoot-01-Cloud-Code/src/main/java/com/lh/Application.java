package com.lh;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //启动springboot时可以获取到spring容器
        ApplicationContext context = SpringApplication.run(Application.class, args);
        //获取所以容器中的组件（对象）名称
        String[] beanDefinitionNames = context.getBeanDefinitionNames();


        for (String name:beanDefinitionNames ){
            System.out.println(name);
        }

    }

}
