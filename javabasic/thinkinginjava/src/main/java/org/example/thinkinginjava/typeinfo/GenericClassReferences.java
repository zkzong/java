package com.example.thinkinginjava.typeinfo;

/**
 * Created by Zong on 2016/9/20.
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intClass = double.class;
//        genericIntClass = double.class; // Illegal
    }
}
