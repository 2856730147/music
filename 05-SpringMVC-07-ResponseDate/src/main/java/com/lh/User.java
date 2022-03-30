package com.lh;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String name;
    private Integer age;
    private  String gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date birthday;
    private  String info;
}
