package org.example.collection.list.fault;

import java.util.List;

public class T2 extends Thread {
    private List<Integer> list;

    public T2(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
    }
}
