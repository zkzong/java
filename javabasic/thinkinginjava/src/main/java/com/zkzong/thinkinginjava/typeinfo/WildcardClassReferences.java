package com.zkzong.thinkinginjava.typeinfo;

/**
 * Created by Zong on 2016/9/20.
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
