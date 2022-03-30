package com.lh.factory;

import com.lh.entity.Student;

public class StudentFactory {
    public Student getStudent(){
        return new Student();
    }

}
