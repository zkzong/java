package com.zkzong.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zong on 16-8-6.
 */
public class ArraysTest {
    public static void main(String[] args) {
        String[] strArray = {"a", "b", "c", "d"};
        List<String> stringList = Arrays.asList(strArray);
        System.out.println(stringList);
        strArray[0] = "aaa";
        System.out.println(stringList);

        String str = "a, b, c,,";
        String[] ary = str.split(",");
        for (int i = 0; i < ary.length; i++) {
            String s = ary[i];
            System.out.println(s);
        }
        System.out.println(ary.length);

        // 空指针异常
        String[] nullArr = null;
        for (String s : nullArr) {
            System.out.println(s);
        }

    }
}
