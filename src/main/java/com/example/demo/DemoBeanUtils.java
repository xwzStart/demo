package com.example.demo;

import com.example.pojo.Student;
import com.example.pojo.Teacher;
import org.springframework.beans.BeanUtils;



public class DemoBeanUtils {
    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();
        teacher.setAge(Integer.parseInt(student.getAge()));
        BeanUtils.copyProperties(student,teacher);
        System.out.println(teacher);
    }
}
