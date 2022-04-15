package com.zkzong.algorithm.sort;

import org.junit.Test;

/**
 * @Author: Zong
 * @Date: 2018/12/7
 */
public class QuickSortTest {

    @Test
    public void quickSort() {
        int[] source = {5, 9, 3, 7, 4, 6, 1};
        QuickSort.quickSort(source, 0, source.length - 1);
        for (int i = 0; i < source.length; i++) {
            int i1 = source[i];
            System.out.print(i1 + " ");
        }
    }

    @Test
    public void qsort() {
        int[] source = {5, 9, 3, 7, 4, 6, 1};
        QuickSort.qsort(source, 0, source.length - 1);
        for (int i = 0; i < source.length; i++) {
            int i1 = source[i];
            System.out.print(i1 + " ");
        }
    }

}