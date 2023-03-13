package org.example.segmentfault.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Zong on 2017/1/23.
 */
public class RunnableTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("使用线程池运行Runnable任务：");

        ExecutorService threadPool = Executors.newFixedThreadPool(5); // 创建大小固定为5的线程池

        List<AccumRunnable> tasks = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            AccumRunnable task = new AccumRunnable(i * 10 + 1, (i + 1) * 10);
            tasks.add(task);

            threadPool.execute(task); // 让线程池执行任务task
        }
        threadPool.shutdown(); // 向线程池发送关闭的指令，等到已经提交的任务都执行完毕之后，线程池会关闭

        threadPool.awaitTermination(1, TimeUnit.HOURS); // 等待线程池关闭，等待的最大时间为1小时

        int total = 0;
        for (AccumRunnable task : tasks) {
            total += task.getResult(); // 调用在AccumRunnable定义的getResult方法获得返回的结果
        }
        System.out.println("Total: " + total);
    }

    static final class AccumRunnable implements Runnable {
        private final int begin;
        private final int end;

        private int result;

        public AccumRunnable(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            result = 0;
            try {
                for (int i = begin; i <= end; i++) {
                    result += i;
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.out.printf("(%s) - 运行结束，结果为%d%n",
                    Thread.currentThread().getName(), result);
        }

        public int getResult() {
            return result;
        }
    }

}
