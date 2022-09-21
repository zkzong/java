package org.example.algorithm.sort;

import org.junit.Test;

/**
 * @Author: Zong
 * @Date: 2018/12/7
 */
public class InsertSortTest {

    @Test
    public void insertSort() {
        int[] source = {5, 9, 3, 7, 4, 6, 1};
        InsertSort.insertSort(source);
        for (int i = 0; i < source.length; i++) {
            int i1 = source[i];
            System.out.print(i1 + " ");
        }
    }
}