package org.example.test;

import org.junit.Test;

public class ForTest {

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            final int j = i;
            new Thread() {
                @Override
                public void run() {
                    System.out.println(j);
                    if (j == 10) {
                        System.out.println("===================");
                        return;
                    }
                }
            }.start();
        }
    }

}
