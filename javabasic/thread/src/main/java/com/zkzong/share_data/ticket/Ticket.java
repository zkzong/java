package com.zkzong.share_data.ticket;

public class Ticket implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        while (ticket > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket--;
            System.out.println(Thread.currentThread().getName() + "，当前票数为：" + ticket);
        }
    }
}
