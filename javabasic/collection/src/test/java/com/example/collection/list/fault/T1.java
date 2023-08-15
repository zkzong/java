package com.example.collection.list.fault;

import java.util.List;

public class T1 extends Thread {
    private List<Integer> list;

    public T1(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (Integer i : list) {
        }
    }
}
