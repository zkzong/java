package com.example.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: zongz
 * @Date: 2024-12-08
 */
class FibonacciTask extends RecursiveTask<Integer> {

    private final int n;

    FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FibonacciTask f1 = new FibonacciTask(n - 1);
        FibonacciTask f2 = new FibonacciTask(n - 2);
        f1.fork(); // 异步执行
        return f2.compute() + f1.join(); // 等待结果并合并
    }

}

public class ForkJoinExample {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();
        FibonacciTask task = new FibonacciTask(10);
        System.out.println(pool.invoke(task)); // 输出 Fibonacci(10) 的结果：55

        ArrayTransformAction arrayTransformAction = new ArrayTransformAction(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 10);
        System.out.println(pool.invoke(arrayTransformAction));

    }

}

class ArrayTransformAction extends RecursiveAction {

    private final int[] arr;
    private final int start, end;

    ArrayTransformAction(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= 10) {
            // 当任务足够小直接计算
            for (int i = start; i < end; i++) {
                arr[i] *= 2; // 假定简单的任务：每一个数字乘以 2
            }
        } else {
            // 任务切分
            int middle = (start + end) / 2;
            ArrayTransformAction task1 = new ArrayTransformAction(arr, start, middle);
            ArrayTransformAction task2 = new ArrayTransformAction(arr, middle, end);
            invokeAll(task1, task2); // 并行处理两个子任务
        }
    }

}
