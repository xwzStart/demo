package com.example.demo;

import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        Map< String,Integer> map = new HashMap<>();
        map.put("橘子",6);
        map.put("永泰",8);
        map.put("恩佐",9);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + value);
        }
//        map.forEach((k,v) -> System.out.println(k + v));
    }

    @Test
    void contextLoads2() {
        int a = 1;
        int b = 2;
        int c = 0;
        boolean flag = true;
        if(!flag){
          c = a + b;
        }else{
            c = a - b;
        }
        System.out.println(c);
    }

    @Test
    void contextLoads3() {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        System.out.println("intList" + intList);

        List<Integer> list = null;
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println("list" + list);
    }
}
