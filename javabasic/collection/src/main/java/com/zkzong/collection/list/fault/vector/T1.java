package com.zkzong.collection.list.fault.vector;

import java.util.Vector;

public class T1 extends Thread {
    private Vector<Integer> vector;

    public T1(Vector<Integer> vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (Integer i : vector) {
        }
    }
}
