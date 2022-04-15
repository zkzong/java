package com.zkzong.algorithm.sort;

/**
 * Created by Zong on 2016/12/2.
 * 快速排序
 */
public class QuickSort {
    public static int partition(int[] source, int left, int right) {
        int tmp;
        int pivot = source[left];
        while (left < right) {
            while (left < right && source[right] >= pivot) {
                right--;
            }
            tmp = source[right];
            source[right] = source[left];
            source[left] = tmp;
            while (left < right && source[left] <= pivot) {
                left++;
            }
            tmp = source[right];
            source[right] = source[left];
            source[left] = tmp;
        }
        source[left] = pivot;
        return left;
    }

    public static void quickSort(int[] source, int left, int right) {
        if (left > right - 1) {
            return;
        }
        int pivot = partition(source, left, right);
        quickSort(source, left, pivot - 1);
        quickSort(source, pivot + 1, right);
    }

    public static void qsort(int[] source, int low, int high) {
        int i, j, x;
        if (low < high) {
            i = low;
            j = high;
            x = source[i];
            while (i < j) {
                while (i < j && source[j] > x) {
                    j--;
                }
                if (i < j) {
                    source[i] = source[j];
                    i++;
                }
                while (i < j && source[i] < x) {
                    i++;
                }
                if (i < j) {
                    source[j] = source[i];
                    j--;
                }
            }
            source[i] = x;
            qsort(source, low, i - 1);
            qsort(source, i + 1, high);
        }
    }



}
