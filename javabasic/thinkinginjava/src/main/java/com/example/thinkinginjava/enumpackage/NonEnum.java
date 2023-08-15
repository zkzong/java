package com.example.thinkinginjava.enumpackage;

/**
 * Created by Zong on 2016/8/25.
 */
public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for (Object en : intClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
