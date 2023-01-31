package com.example.demo;

public class DemoForReturn {
    public static void main(String[] args) {
        System.out.println(testFor());
    }

    private static Integer testFor(){
        int a = 2;
        int b =3;
        for (int i = 0; i < 10; i++) {
            if(b > a){
                System.out.println("hh");
                return 6;
            }
        }
        return 9;
    }
}
