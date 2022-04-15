package com.zkzong.algorithm.sort;

import org.junit.Test;

/**
 * @Author: Zong
 * @Date: 2018/12/8
 */
public class SelectionSortTest {

    @Test
    public void selectionSort() {
        int[] source = {5, 9, 3, 7, 4, 6, 1};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(source);
        for (int i = 0; i < source.length; i++) {
            int i1 = source[i];
            System.out.print(i1 + " ");
        }
    }
}