package com.zkzong.collection.list.fault;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        T1 t1 = new T1(list);
        T2 t2 = new T2(list);
        t1.start();
        t2.start();
    }
}
