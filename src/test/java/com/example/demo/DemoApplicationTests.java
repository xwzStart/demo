package com.example.demo;

import com.example.pojo.Student;
import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.DateUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Test
    void contextLoads5() {
        String name = "zhangsan";
        Assert.isTrue(!"zhangsan".equals(name),"事项等的");
    }

    @Test
    void contextLoads6() {
        Instant ins1 = Instant.parse("2006-04-03T05:10:15.00Z");
        Instant ins2 = Instant.parse("2006-04-03T05:10:15.00Z");
        boolean flag = ins1.isBefore(ins2);
        System.out.println(flag);

        Instant instant = Instant.now();
        System.out.println(instant);

    }

    @Test
    void contextLoads7() {
        List<String> list = Arrays.asList("1","2","3","4");
//        Double collect = list.stream().collect(Collectors.averagingDouble(d -> d * 2));
        String result=  list.stream().collect(Collectors.joining("*","(",")"));
        System.out.println(result);
    }

    @Test
    void contextLoads8() {
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);
        System.out.println(date1);
    }

    @Test
    void contextLoads9() {
        List<String> args = Arrays.asList("ni","hao","world");
        String collect = args.stream().collect(Collectors.joining(",","[","]"));
        System.out.println(collect);
    }

    @Test
    void contextLoads10() {
        String flag = "";
        String flagNull = null;
        System.out.println(StringUtils.isNotBlank(flag));
        System.out.println(StringUtils.isNotEmpty(flag));
    }

    @Test
    void contextLoads11() {
        String flag = "01a2345a63a789a";
        System.out.println(flag.indexOf("a"));
        System.out.println(flag.lastIndexOf("a"));
    }

    @Test
    void contextLoads12() {
        String name = "AfFBfnx";
        String flag = name.substring(0,1).toLowerCase() + name.substring(1).toLowerCase();
        String currentTime = LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(formatter);
        System.out.println(format);
        System.out.println(currentTime);
        System.out.println(flag);
    }

    @Test
    void contextLoads13() {
        String flag = "abc,123,def,789,ghi";
        String[] array = flag.split(",");
        List<String> strings = new ArrayList<>();
        strings.add("123");
        strings.add("abc");
        for (String string : strings) {
            if("abc".equals(string)){
                String s = string.toUpperCase();
                System.out.println(s);
            }

        }
        System.out.println("*****");
        for (String s : array) {
            System.out.println(s);
        }
        System.out.println("*****");
        List<String> arrayList = Lists.newArrayList(array);
        for (String s : arrayList) {
            if("abc".equals(s)){
                s.toUpperCase();
            }
            System.out.println(s);
        }
    }
    @Test
    void contextLoads15(){
        // 创建一个 HashMap
        Map<Integer, String> sites = new HashMap<>();
        List<String> list = new ArrayList<>();

        list.add("elang");
        list.add("asd");
        list.add("qwe");
        // 往 HashMap 添加一些元素
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        System.out.println("sites HashMap: " + sites);
        System.out.println("sites List: " + list);

        // key 的映射存在于 HashMap 中
        // Not Found - 如果 HashMap 中没有该 key，则返回默认值
        String value1 = sites.getOrDefault(1, "Not Found");
        System.out.println("Value for key 1:  " + value1);

        // key 的映射不存在于 HashMap 中
        // Not Found - 如果 HashMap 中没有该 key，则返回默认值
        String value2 = sites.getOrDefault(4, "Not Found");
        System.out.println("Value for key 4: " + value2);
    }

    @Test
    void contextLoads16(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", 19));
        list.add(new Student("王五", 19));
        list.add(new Student("李四", 19));
        boolean flag = list.stream().anyMatch(stu -> "张三".equals(stu.getName()));
        System.out.println(flag);

    }

    @Test
    void contextLoads17(){
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(sum(a,b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }

}
