package com.zkzong.snowflake;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zkzong
 * @Date: 2018.8.16
 */
public class SnowFlake {

    @Test
    public void id() {
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId());
                    System.out.println(IdGenerator.generateId());
                }
            });
        }
    }
}
