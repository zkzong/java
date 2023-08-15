package com.example.string;

import org.junit.Test;

/**
 * Created by Zong on 2017/2/4.
 */
public class StringEquals {
    @Test
    public void equals() {
        String get = "get";
        String GET = "GET";

        System.out.println(get.equals(GET)); // false
        System.out.println(get.equalsIgnoreCase(GET)); // true

    }

    @Test
    public void e1() {
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
    }

    /**
     * 字符串使用 final 关键字声明之后，可以让编译器当做常量来处理。
     * 被 final 关键字修改之后的 String 会被编译器当做常量来处理，编译器在程序编译期就可以确定它的值，其效果就相当于访问常量。
     */
    @Test
    public void e2() {
        final String str1 = "str";
        final String str2 = "ing";
        // 下面两个表达式其实是等价的
        String c = "str" + "ing";// 常量池中的对象
        String d = str1 + str2; // 常量池中的对象
        System.out.println(c == d);// true
    }

    /**
     * 如果 ，编译器在运行时才能知道其确切值的话，就无法对其优化。
     */
    @Test
    public void e3() {
        final String str1 = "str";
        final String str2 = getStr();
        String c = "str" + "ing";// 常量池中的对象
        String d = str1 + str2; // 在堆上创建的新的对象
        System.out.println(c == d);// false
    }

    public static String getStr() {
        return "ing";
    }
}
