package com.zkzong.algorithm.sort;

/**
 * Created by Zong on 2016/11/29.
 * 交换元素
 */
public class SortUtil {
    public static void swap(int[] source, int x, int y) {
        int temp = source[x];
        source[x] = source[y];
        source[y] = temp;
    }
}
