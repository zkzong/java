package com.zkzong.share_data.bank;

public class TestOne {
    public static void main(String[] args) {
        MyData data = new MyData();
        Runnable add = new AddRunnable(data);
        Runnable dec = new DecRunnable(data);
        for (int i = 0; i < 20; i++) {
            new Thread(add).start();
            new Thread(dec).start();
        }
    }
}
