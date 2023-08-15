package com.example.guava;

import com.google.common.primitives.Ints;

import java.util.List;

public class IntsTest {
    public static void main(String[] args) {
        List<Integer> list = Ints.asList(1, 3, 5, 7, 9);
        System.out.println(list);
        // [1, 3, 5, 7, 9]

        System.out.println(Ints.join(",", 1, 3, 1, 4));
        // 1,3,1,4

        // 原生类型数组快速合并
        int[] newIntArray = Ints.concat(new int[]{1, 2}, new int[]{2, 3, 4});
        System.out.println(newIntArray.length); // 5

        // 最大/最小
        System.out.println(Ints.max(newIntArray) + ", " + Ints.min(newIntArray));
        // 4, 1

        // 是否包含
        System.out.println(Ints.contains(newIntArray, 6));
        // false

        // 集合到数组的转换
        int[] someArray = Ints.toArray(list);
        System.out.println(someArray.length);
        // 5
    }
}
