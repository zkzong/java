package com.zkzong.collection.list.fault.vector;

import java.util.Vector;

public class T2 extends Thread {
    private Vector<Integer> vector;

    public T2(Vector<Integer> vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.size(); i++) {
            vector.remove(i);
        }
    }
}
