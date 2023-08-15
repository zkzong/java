package com.example.algorithm.sort;

/**
 * Created by Zong on 2016/11/29.
 * 选择排序
 */
public class SelectionSort {
    public void selectionSort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int k = i;
            for (int j = i; j < source.length; j++) {
                if (source[k] > source[j]) {
                    k = j;
                }
            }
            if (k != i) {
                SortUtil.swap(source, i, k);
            }
        }
    }

}
