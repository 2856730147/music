package com.lh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
//swagger2.10.5要用这个注解
//swagger2.9.x用的都是@EnableSwagger
@EnableSwagger2WebMvc

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
