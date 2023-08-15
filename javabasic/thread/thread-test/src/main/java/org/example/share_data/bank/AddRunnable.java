package com.example.share_data.bank;

public class AddRunnable implements Runnable {
    MyData data;

    public AddRunnable(MyData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data.add();
    }
}
