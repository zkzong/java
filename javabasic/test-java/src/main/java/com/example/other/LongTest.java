package com.example.other;

/**
 * Created by Zong on 2016/6/30.
 */
public class LongTest {
    public static void main(String[] args) {
        Long l1 = 123L;
        Long l2 = 123L;
        System.out.println(l1 == l2);//true
        System.out.println(l1.equals(l2));//true

        Long l3 = new Long("123");
        Long l4 = new Long("123");
        System.out.println(l3 == l4);//false
        System.out.println(l3.equals(l4));//true

    }
}
