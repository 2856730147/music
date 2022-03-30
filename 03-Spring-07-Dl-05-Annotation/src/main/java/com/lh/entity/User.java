package com.lh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@AllArgsConstructor


//把当前类的对象放到容器中
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class User {
    @Value("101")
    private Integer id;
    @Value("大青蛙对")
    private String username;
    @Value("123345")
    public String password;

    public User() {
        System.out.println("无参构造");
    }

    @PostConstruct
//会在创建对象前执行
    public void  eat(){
        System.out.println("分为");
    }
//    在容器销毁之前
    @PreDestroy
    public  void sleep(){
        System.out.println("阿斯顿");
    }
}
