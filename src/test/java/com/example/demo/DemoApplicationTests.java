package com.example.demo;

import com.example.pojo.Person;
import com.example.pojo.Student;
import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.DateUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        Map<String, Integer> map = new HashMap<>();
        map.put("橘子", 6);
        map.put("永泰", 8);
        map.put("恩佐", 9);
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
        if (!flag) {
            c = a + b;
        } else {
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
        Assert.isTrue(!"zhangsan".equals(name), "事项等的");
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
        List<String> list = Arrays.asList("1", "2", "3", "4");
//        Double collect = list.stream().collect(Collectors.averagingDouble(d -> d * 2));
        String result = list.stream().collect(Collectors.joining("*", "(", ")"));
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
        List<String> args = Arrays.asList("ni", "hao", "world");
        String collect = args.stream().collect(Collectors.joining(",", "[", "]"));
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
        String flag = name.substring(0, 1).toLowerCase() + name.substring(1).toLowerCase();
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
            if ("abc".equals(string)) {
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
            if ("abc".equals(s)) {
                s.toUpperCase();
            }
            System.out.println(s);
        }
    }

    @Test
    void contextLoads15() {
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
    void contextLoads16() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", 19));
        list.add(new Student("王五", 19));
        list.add(new Student("李四", 19));
        boolean flag = list.stream().anyMatch(stu -> "张三".equals(stu.getName()));
        System.out.println(flag);

    }

    @Test
    void contextLoads17() {
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }

    @Test
    void contextLoads18() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Map<String, Person> collect = personList.stream().filter(x -> x.getSalary() > 8000)
                .collect(Collectors.toMap(x -> x.getName(), x -> x));
        System.out.print("高于8000的员工姓名：" + collect);
    }

    @Test
    void contextLoads19() {
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(x -> x.length()));
//        System.out.println(max);

        List<Integer> list2 = Arrays.asList(7, 6, 9, 4, 6);
        Optional<Integer> max1 = list2.stream().max(Integer::compareTo);
        Optional<Integer> max2 = list2.stream().max(Comparator.comparingInt(x -> x));
//        System.out.println(max1);

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 16200, 24, "female", "New York"));
        personList.add(new Person("Owen", 7000, 25, "male", "New York"));
        personList.add(new Person("Alisa", 8900, 26, "female", "New York"));

        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println(sumSalary);
        List<Integer> collect = personList.stream().map(Person::getSalary).collect(Collectors.toList());
        int sum = 0;
        for (Integer i : collect) {
            sum += i;

        }
//        System.out.println(sum);

        Optional<Integer> reduce1 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        Integer reduce2 = personList.stream().map(Person::getSalary).reduce(1, Integer::sum);
//        System.out.println(reduce1);
//        System.out.println(reduce2);
        //按照工资升序
        List<String> collect1 = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        System.out.println(collect1);
        //按照工资升序,工资相同的话,按照名字长度降序
        List<String> collect2 = personList.stream().sorted((s1, s2) -> {
            if (Objects.equals(s1.getSalary(), s2.getSalary())) {
                return s2.getName().length() - s1.getName().length();
            } else {
                return s1.getSalary() - s2.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());
        System.out.println(collect2);
    }

    @Test
    void contextLoads20() {
        Integer a = 10;
        Long b = 11L;
        long l = a.longValue();
        int i = b.intValue();

        System.out.println(l);
        System.out.println();
    }

    @Test
    void contextLoads21() {
        System.out.println(String.format("%s,hhhh,%s", "6", "7"));
    }

    @Test
    void contextLoads22() {
        BigDecimal decimal = new BigDecimal("100");

        System.out.println(decimal.multiply(new BigDecimal(1)));
    }

    @Test
    void contextLoads23() {
        String USERNAME_REGEX_EXP = "^[a-zA-Z]\\w{4,15}$";
        String username = "p____0_";
        Pattern pattern = Pattern.compile(USERNAME_REGEX_EXP);
        Matcher matcher = pattern.matcher(username);
        boolean flag = matcher.matches();
        String ecos = flag == true ? username : "请输入正确的用户名!";
        System.out.println(ecos);
    }

    @Test
    void contextLoads25() {
        String abc = camelToUnderline("DSgAcDDDccbC");
        System.out.println(abc);
    }
    public static String camelToUnderline(String para){
        int length = 3;
        if(para.length()<length){
            return para.toLowerCase();
        }
        StringBuilder sb=new StringBuilder(para);
        //定位
        int temp=0;
        //从第三个字符开始 避免命名不规范
        for(int i=2;i<para.length();i++){
            if(Character.isUpperCase(para.charAt(i))){
                sb.insert(i+temp, "_");
                temp+=1;
            }
        }
        return sb.toString().toLowerCase();
    }

    @Test
    void contextLoads26() {
        StringBuilder str = new StringBuilder("tutorials");
        System.out.println("string = " + str);
        CharSequence cSeq = "yiidian";
// insert CharSequence at offset 9
        str.insert(9, cSeq);
// prints StringBuilder after insertion
        System.out.println(str.toString());
    }

    @Test
    void contextLoads27() {
        System.out.println(camelName("_adas_DF_ssS_DFzDDz_cv"));
    }

    public static String camelName(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            return name.substring(0, 1).toLowerCase() + name.substring(1).toLowerCase();
            //update-end--Author:zhoujf  Date:20180503 for：TASK #2500 【代码生成器】代码生成器开发一通用模板生成功能
        }
        // 用下划线将原始字符串分割
        String[] camels = name.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();

    }

    @Test
    void contextLoads28() {
        System.out.println(toCamelCase("asd_AdfgdB_BBf_f"));
    }
    public static String toCamelCase(String inputString) {
        String[] parts = inputString.split("_");
        StringBuilder camelCaseString = new StringBuilder();
        for (String part : parts) {
            if (camelCaseString.length() == 0) {
                camelCaseString.append(part);
            } else {
                camelCaseString.append(part.substring(0, 1).toUpperCase());
                camelCaseString.append(part.substring(1));
            }
        }
        return camelCaseString.toString();
    }
    @Test
    void contextLoads29() {
        System.out.println("新建了一个分支");
    }

    @Test
    void contextLoads30() {

    }

}
