package org.example.algorithm.sort;

/**
 * Created by Zong on 2016/11/29.
 * 冒泡排序
 */
public class BubbleSort {
    public void bubbleSort1(int[] source) {
        int length = source.length;
        for (int i = 0; i < length; i++) {
            // 从最后一个开始，往前比较，小的上浮
            for (int j = length - 1; j > i; j--) {
                if (source[j] < source[j - 1]) {
                    SortUtil.swap(source, j, j - 1);
                }
            }
        }
    }

    public void bubbleSort2(int[] source) {
        int length = source.length;
        for (int i = length - 1; i > 0; i--) {
            // 从第一个开始，往后比较，大的下沉
            for (int j = 0; j < i; j++) {
                if (source[j] > source[j + 1]) {
                    SortUtil.swap(source, j, j + 1);
                }
            }
        }
    }

    /**
     * 引入一个布尔量exchange，在每趟排序开始前，先将其置为true，各趟排序结束时检查exchange，若未曾发生过交换，则终止循环
     *
     * @param source
     */
    public void bubbleSort3(int[] source) {
        int count = 0;
        int i, j;
        boolean exchange;
        int length = source.length;
        for (i = 0; i < length; i++) {
            exchange = false;
            // 自下向上扫描
            for (j = length - 1; j > i; j--) {
                count++;
                if (source[j] < source[j - 1]) {
                    // source[0]做暂存单元
                    source[0] = source[j];
                    source[j] = source[j - 1];
                    source[j - 1] = source[0];
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
        System.out.println("count=" + count);
    }

}
