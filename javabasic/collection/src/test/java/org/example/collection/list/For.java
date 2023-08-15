package com.example.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class For {
    private static int SIZE = 111111;

    private static void loopList(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        System.out.println(list.getClass().getSimpleName() + "使用普通for循环遍历时间为" +
                (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (Integer i : list) {

        }
        System.out.println(list.getClass().getSimpleName() + "使用foreach循环遍历时间为" +
                (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>(SIZE);
        List<Integer> linkedList = new LinkedList<Integer>();

        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        loopList(arrayList);
        loopList(linkedList);
        System.out.println();
    }
    /**
     * ArrayList使用普通for循环遍历时间为8ms
     * ArrayList使用foreach循环遍历时间为14ms
     * LinkedList使用普通for循环遍历时间为10769ms
     * LinkedList使用foreach循环遍历时间为6ms
     */
    // 如果使用普通for循环遍历LinkedList，速度非常慢。建议使用foreach。
}
