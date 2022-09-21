package org.example.sb.async;

import org.example.sb.async.task.AsyncFutureTask;
import org.example.sb.async.task.AsyncTask;
import org.example.sb.async.task.SyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * Created by Zong on 2017/5/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private SyncTask syncTask;
    @Autowired
    private AsyncTask asyncTask;
    @Autowired
    private AsyncFutureTask asyncFutureTask;

    @Test
    public void testSync() throws Exception {
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }

    @Test
    public void testAsync() throws Exception {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncFutureTask.doTaskOne();
        Future<String> task2 = asyncFutureTask.doTaskTwo();
        Future<String> task3 = asyncFutureTask.doTaskThree();
        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}