package com.zkzong.thread;

/**
 * Created by Zong on 2016/11/18.
 */
public class Throw extends Thread {

    @Override
    public void run() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Throw t = new Throw();
        t.start();
    }

}
