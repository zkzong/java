package com.zkzong.algorithm.search;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Zong
 * @Date: 2018/12/7
 */
public class BinarySearchTest {

    @Test
    public void binarySearch() {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(array));
        System.out.println("元素5位于" + BinarySearch.binarySearch(array, 5));
    }
}