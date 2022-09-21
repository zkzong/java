package org.example.share_data.bank;

public class DecRunnable implements Runnable {
    MyData data;

    public DecRunnable(MyData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data.dec();
    }
}
