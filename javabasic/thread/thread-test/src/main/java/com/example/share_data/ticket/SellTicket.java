package com.example.share_data.ticket;

/**
 * 非线程安全
 */
public class SellTicket {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        new Thread(t).start();
        new Thread(t).start();
    }
}
