package com.zkzong.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Zong on 2016/10/12.
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {

        List<String> strList = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            strList.add("String" + i);
        }
        int threadNum = strList.size() < 5 ? strList.size() : 5;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, threadNum, 300, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(3), new ThreadPoolExecutor.CallerRunsPolicy());
        //executor.allowCoreThreadTimeOut(true);
        //executor.prestartCoreThread();
        //executor.prestartAllCoreThreads();
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new PrintStringThread(i, strList, threadNum));
        }
        executor.shutdown();
    }
}

class PrintStringThread implements Runnable {

    private int num;

    private List<String> strList;

    private int threadNum;

    public PrintStringThread(int num, List<String> strList, int threadNum) {
        this.num = num;
        this.strList = strList;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        int length = 0;
        for (String str : strList) {
            if (length % threadNum == num) {
                System.out.println("线程编号：" + num + "，字符串：" + str);
            }
            length++;
        }
    }
}
