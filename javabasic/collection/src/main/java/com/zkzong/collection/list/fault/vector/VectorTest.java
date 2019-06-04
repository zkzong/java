package com.zkzong.collection.list.fault.vector;

import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>();

        for (int i = 0; i < 10000; i++) {
            vector.add(i);
        }

        T1 t1 = new T1(vector);
        T2 t2 = new T2(vector);
        t1.start();
        t2.start();
    }
    // Vector虽然是线程安全的，但是只是一种相对的线程安全而不是绝对的线程安全，
    // 它只能够保证增、删、改、查的单个操作一定是原子的，不会被打断，但是如果组合起来用，并不能保证线程安全性。
}
