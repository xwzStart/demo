package com.example.pojo;

import lombok.Data;

@Data
public class Teacher {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
