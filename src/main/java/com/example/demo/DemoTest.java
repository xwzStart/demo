package com.example.demo;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DemoTest {
    public static void main(String[] args) {
        String password = "18011910187";
        System.out.println(password.substring(5,11));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
    }
}
