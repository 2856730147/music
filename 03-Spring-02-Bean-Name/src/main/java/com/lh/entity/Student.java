package com.lh.entity;

public class Student {
    private Integer id;
    private String naem;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", naem='" + naem + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }
}
