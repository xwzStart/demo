package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoRegex {
    public static final String CHINA_REGEX_EXP =
            "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[0-9])|(18[0-9])|(19[1,8,9]))\\d{8}$";

    public static void main(String[] args) {

        String phoneNum = "18011910187";
        Pattern pattern = Pattern.compile(CHINA_REGEX_EXP);
        Matcher mat = pattern.matcher(phoneNum);
        boolean flag = mat.matches();
        if(!flag){
            System.out.println("手机号错误");
        }else{
            System.out.println("正确");
        }
    }
}
