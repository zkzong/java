package org.example.share_data.bank;

public class MyData {
    private int j = 0;

    public synchronized void add() {
        j++;
        System.out.println("线程" + Thread.currentThread().getName() + "，++，j为：" + j);
    }

    public synchronized void dec() {
        j--;
        System.out.println("线程" + Thread.currentThread().getName() + "，--，j为：" + j);
    }

    public int getData() {
        return j;
    }
}
