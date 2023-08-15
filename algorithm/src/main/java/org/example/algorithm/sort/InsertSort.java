package com.example.algorithm.sort;

/**
 * Created by Zong on 2016/12/2.
 * 插入排序
 */
public class InsertSort {
    public static void insertSort(int[] source) {
        int len = source.length;
        int i, j, key;
        for (i = 1; i < len; i++) {
            key = source[i];
            for (j = i - 1; j >= 0; j--) {
                if (source[j] > key) {
                    source[j + 1] = source[j];
                } else {
                    break;
                }
            }
            source[j + 1] = key;
        }
    }

}
