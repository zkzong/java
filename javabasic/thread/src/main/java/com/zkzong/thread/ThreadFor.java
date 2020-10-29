package com.zkzong.thread;

public class ThreadFor {

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            final int j = i;
            //System.out.println(j);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new RuntimeException(j + "");
                    System.out.println(j);
                }
            }).start();
        }
    }
}
