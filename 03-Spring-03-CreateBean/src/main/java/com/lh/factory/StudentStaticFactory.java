package com.lh.factory;

import com.lh.entity.Student;

public class StudentStaticFactory {
    public static Student getStudent(){
        return new Student();
    }
}
