package org.example.segmentfault;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Zong on 2017/1/8.
 */
public class CallableTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("使用Callable获得返回结果");

        List<FutureTask<Integer>> futureTasks = new ArrayList<>(10);

        // 新建 10 个线程，每个线程分别负责累加 1~10, 11~20, ..., 91~100
        for (int i = 0; i < 10; i++) {
            AccumCallable task = new AccumCallable(i * 10 + 1, (i + 1) * 10);
            FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
            futureTasks.add(futureTask);

            Thread worker = new Thread(futureTask, "慢速累加器线程" + i);
            worker.start();
        }

        int total = 0;
        for (FutureTask<Integer> futureTask : futureTasks) {
            total += futureTask.get(); // get()方法会阻塞直到获得结果
        }
        System.out.println("\n累加的结果：" + total);
    }

    static final class AccumCallable implements Callable<Integer> {
        private final int begin;
        private final int end;

        public AccumCallable(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public Integer call() throws InterruptedException {
            int result = 0;
            for (int i = begin; i <= end; i++) {
                result += i;
                Thread.sleep(100);
            }

            System.out.printf("(%s) - 运行结束，结果为%d%n",
                    Thread.currentThread().getName(), result);

            return result;
        }

    }
}
