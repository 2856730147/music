package com.lh.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//条件装配，满足装配才行
@Profile("product")
@ConfigurationProperties("student")
@Data
@Component
public class Son implements Student {
    private  String name;
    private  Integer age;
}
