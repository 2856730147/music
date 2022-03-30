package com.lh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private  String name;
    private Integer age;
    private String gender;
    @JsonFormat(pattern = "yyy-mm-dd HH:mm:ss")
    private Date birthday;
    private  String info;
}
