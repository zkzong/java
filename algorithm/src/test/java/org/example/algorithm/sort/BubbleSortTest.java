package org.example.algorithm.sort;

import org.junit.Test;

/**
 * @Author: Zong
 * @Date: 2018/12/7
 */
public class BubbleSortTest {

    @Test
    public void bubbleSort1() {
        int[] source = {5, 9, 3, 7, 4, 6, 1};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort1(source);
        for (int i = 0; i < source.length; i++) {
            int i1 = source[i];
            System.out.print(i1 + " ");
        }
    }

    @Test
    public void bubbleSort2() {
        int[] source = {5, 9, 3, 7, 4, 6, 1};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort2(source);
        for (int i = 0; i < source.length; i++) {
            int i1 = source[i];
            System.out.print(i1 + " ");
        }
    }

    @Test
    public void bubbleSort3() {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort3(source);
        for (int i = 0; i < source.length; i++) {
            int i1 = source[i];
            System.out.print(i1 + " ");
        }
    }
}