package org.example.java.util.concurrent.countdownlatch.wait;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zkzong
 * @date 2017/10/16
 */
public class MyService {
    private CountDownLatch count = new CountDownLatch(1);

    public void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + " 准备 " + System.currentTimeMillis());
            count.await(3, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + " 结束 " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
