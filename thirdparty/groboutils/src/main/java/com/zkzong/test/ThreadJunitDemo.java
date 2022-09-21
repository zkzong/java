package org.example.test;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;
import org.junit.Test;

/**
 * 多线程测试用例
 *
 * @author zkzong
 * @date 2017/12/12
 */
public class ThreadJunitDemo {

    private static final int THREAD_COUNT = 10;

    @Test
    public void testThreadJunit() {
        try {
            // Runner数组，相当于并发多少个
            TestRunnable[] trs = new TestRunnable[THREAD_COUNT];
            for (int i = 0; i < THREAD_COUNT; i++) {
                trs[i] = new TestRunnable() {
                    @Override
                    public void runTest() throws Throwable {
                        commMethod();
                    }
                };
            }

            // 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
            MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
            // 并发执行数组里定义的内容
            mttr.runTestRunnables();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void commMethod() {
        System.out.println("===" + Thread.currentThread().getId() + "begin to execute ...");
        for (int i = 0; i < 10; i++) {
             int a = i * 5;
            System.out.println(a);
        }
        System.out.println("===" + Thread.currentThread().getId() + "end to execute ...");
    }

}
