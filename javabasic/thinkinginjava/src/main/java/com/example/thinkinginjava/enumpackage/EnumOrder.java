package com.example.thinkinginjava.enumpackage;

/**
 * Created by zong on 2016/8/25.
 */
public class EnumOrder {
    // 在创建enum时，编译器会自动添加一些有用的特性
    // toString()方法：可以很方便地显示某个enum实例的名字
    // ordinal()方法：用来表示某个特定enum常量的声明顺序
    // static values()方法：用来按照enum常量的声明顺序，产生由这些常量值构成的数组
    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values()) {
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
}
