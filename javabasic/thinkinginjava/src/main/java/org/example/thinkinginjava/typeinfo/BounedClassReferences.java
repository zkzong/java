package com.example.thinkinginjava.typeinfo;

/**
 * Created by Zong on 2016/9/20.
 */
public class BounedClassReferences {
    public static void main(String[] args) {
//        Class<Number> genericNumberClass = int.class;

        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
