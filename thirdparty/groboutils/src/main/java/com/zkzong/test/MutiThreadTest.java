package org.example.test;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;
import org.junit.Test;

/**
 * @author zkzong
 * @date 2017/12/12
 */
public class MutiThreadTest {
    @Test
    public void testThreadJunit() throws Throwable {
        // Runner数组，想当于并发多少个。
        TestRunnable[] trs = new TestRunnable[10];
        for (int i = 0; i < 10; i++) {
            trs[i] = new ThreadA();
        }

        // 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
        MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
        // 开发并发执行数组里定义的内容
        mttr.runTestRunnables();
    }

    private class ThreadA extends TestRunnable {
        @Override
        public void runTest() throws Throwable {
            // 测试内容
            myCommMethod2();
        }
    }

    public void myCommMethod2() throws Exception {
        System.out.println("===" + Thread.currentThread().getId() + "begin to execute myCommMethod2");
        for (int i = 0; i < 10; i++) {
            int a = i * 5;
            System.out.println(a);
        }
        System.out.println("===" + Thread.currentThread().getId() + "end to execute myCommMethod2");
    }
}
