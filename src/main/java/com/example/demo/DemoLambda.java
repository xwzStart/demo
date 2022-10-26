package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class DemoLambda {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> collect = list.stream().filter(t -> list.get(t).length()>2)
//                .collect(Collectors.toList());
//        ArrayList<String> strings = new ArrayList<>();
//        for (String s : list) {
//            if(s.length() >2){
//                strings.add(s);
//            }
//        }
        list.forEach(t-> {
            if(t.length() > 3){
                System.out.println(t);
            }
        });

    }
}
