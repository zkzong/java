package com.zkzong.interview.parameter;

/**
 * Created by Zong on 2016/12/4.
 */
public class NameClass {
    private static int x;

    public static void main(String[] args) {
        name(x);
        System.out.println(x); // 0
    }

    public static void name(int x) {
        x++;
    }
}
/*
name()方法中的参数名与静态变量名是相同的，所以在进行x++时，改变的是参数x的值而不是静态变量x的值。
这时静态变量x还有另一种身份，即全局变量，当然参数x就是局部变量，它的使用范围仅在name()方法中。
所以在main()方法中只能调用静态变量。
 */
