package com.example.pojo;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String age = "12";

    public String getName(String name) {
        this.name = "橘子";
        return name;
    }
}
