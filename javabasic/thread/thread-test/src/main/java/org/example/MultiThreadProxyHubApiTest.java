package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadProxyHubApiTest {
    static int count = 0;
    //总访问量是client_num，并发量是thread_num
    int thread_num = 10;
    int client_num = 1000;
    float avg_exec_time = 0;
    float sum_exec_time = 0;
    long first_exec_time = Long.MAX_VALUE;
    long last_done_time = Long.MIN_VALUE;
    float total_exec_time = 0;

    String url = "";
    String postData = "";

    public MultiThreadProxyHubApiTest(int thread_num, int client_num, String url, String postData) {
        this.thread_num = thread_num;
        this.client_num = client_num;
        this.url = url;
        this.postData = postData;
    }

    public void run() {

        final MultiThreadProxyHubApiTest currentObj = this;

        final ConcurrentHashMap<Integer, ThreadRecord> records = new ConcurrentHashMap<Integer, ThreadRecord>();

        // 建立ExecutorService线程池
        ExecutorService exec = Executors.newFixedThreadPool(thread_num);
        // thread_num个线程可以同时访问
        // 模拟client_num个客户端访问
        final CountDownLatch doneSignal = new CountDownLatch(client_num);

        for (int i = 0; i < client_num; i++) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    int index = getIndex();
                    long st = System.currentTimeMillis();

                    try {
                        //这里引用一些开源包，看者可自行修改
                        URLConnection urlconn = ConnectionManager.openUrlConnection(currentObj.url, currentObj.postData);
                        //HttpURLConnection urlconn = ConnectionManager.openUrlConnection(currentObj.url, currentObj.postData);
                        //URLConnection = new URLConnection();
                        urlconn.setReadTimeout(50000);

                        BufferedReader reader = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));

                        String src = "";
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            src = src + line;
                        }
                        //System.out.println(src);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    records.put(index, new ThreadRecord(st, System.currentTimeMillis()));
                    doneSignal.countDown();//每调用一次countDown()方法，计数器减1
                }
            };
            exec.execute(run);
        }

        try {
            //计数器大于0 时，await()方法会阻塞程序继续执行
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 获取每个线程的开始时间和结束时间
         */
        for (int i : records.keySet()) {
            ThreadRecord r = records.get(i);
            sum_exec_time += ((double) (r.et - r.st)) / 1000;

            if (r.st < first_exec_time) {
                first_exec_time = r.st;
            }
            if (r.et > last_done_time) {
                this.last_done_time = r.et;
            }
        }

        this.avg_exec_time = this.sum_exec_time / records.size();
        this.total_exec_time = ((float) (this.last_done_time - this.first_exec_time)) / 1000;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(4);


        System.out.println("======================================================");
        System.out.println("线程数量: " + thread_num + ", 客户端数量 : " + client_num + ".");
        System.out.println("评均执行时间:   " + nf.format(this.avg_exec_time) + " s");
        System.out.println("总执行时间: " + nf.format(this.total_exec_time) + " s");
        System.out.println("流率:      " + nf.format(this.client_num / this.total_exec_time) + " /s");
    }

    public static int getIndex() {
        return ++count;
    }

    public static void main(String[] args) {
        //总访问量和并发量两重循环，依次增大访问
        for (int j = 500; j < 600; j += 100) {
            for (int i = 10; i < 100; i += 10) {
                //要测试的URL
                String url = "https://www.zhihu.com/";
                new MultiThreadProxyHubApiTest(i, j, url, "").run();
            }
        }
        System.out.println("finished!");
    }
}

class ThreadRecord {
    long st;
    long et;

    public ThreadRecord(long st, long et) {
        this.st = st;
        this.et = et;
    }
}


