package com.zkzong.sb.mybatis.service;

import com.zkzong.sb.mybatis.domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CityServiceTest {
    @Autowired
    private CityService cityService;

    @Test
    public void findCityByName() throws Exception {
        City city = cityService.findCityByName("温岭市");
        System.out.println(city);
    }

    // todo
    @Test
    public void findCityByName1() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    City city = cityService.findCityByName("温岭市");
                    System.out.println(city);
                    System.out.println("测试");
                }
            });
            Thread.sleep(100);
        }
    }

    // todo
    @Test
    public void findCityByName2() throws Exception {
        CountDownLatch start = new CountDownLatch(1);// 初始化计数器为 一
        for (int i = 0; i < 16; i++) {//模拟16个线程
            MyThread tt = new MyThread(start);
            Thread t = new Thread(tt);
            t.start();
        }
        start.countDown();//计数器減一  所有线程释放 同时跑
    }

    class MyThread implements Runnable {

        private final CountDownLatch startSignal;

        public MyThread(CountDownLatch startSignal) {
            super();
            this.startSignal = startSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await(); //一直阻塞当前线程，直到计时器的值为0
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doWork();
        }

        private void doWork() {
            City city = cityService.findCityByName("温岭市");
            System.out.println(city);
        }
    }

    @Test
    public void findCityByName3() throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(100);
        for (int i = 0; i < 16; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semp.acquire();
                        City city = cityService.findCityByName("温岭市");
                        System.out.println(city);
                        System.out.println("a");
                        semp.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        exec.shutdown();
    }

}

