package org.example;

import java.util.Arrays;

/**
 * Created by Zong on 2016/7/21.
 */
public class Sout {
    public static void main(String[] args) {
//        System.out.println("0");
//        System.out.println("1");
//        System.err.println("2");
//        System.out.println("3");

        int[] intArr = {1, 2, 3, 4, 5};
        int[] ints = Arrays.copyOf(intArr, intArr.length);
        for (int i = 0; i < ints.length; i++) {
            int anInt = ints[i];
            System.out.println(anInt);
        }

        String a = "1";
        String b = "1" + "2";
        String c = "12";
        System.out.println(b == c); // true
        System.out.println(b.equals(c)); // true
    }
}
