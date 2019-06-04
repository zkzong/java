package com.zkzong.share_data.bank;

public class TestThread {
    public static void main(String[] args) {
        final MyData data = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data.add();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data.dec();
                }
            }).start();
        }
    }
}
