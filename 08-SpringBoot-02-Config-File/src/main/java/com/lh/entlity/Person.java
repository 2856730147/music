package com.lh.entlity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties(prefix = "person")
public class Person {
    private String username;
}
