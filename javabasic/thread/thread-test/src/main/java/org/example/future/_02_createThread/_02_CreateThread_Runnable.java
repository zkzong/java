package org.example.future._02_createThread;


public class _02_CreateThread_Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> System.out.println("我是子线程")
        );
        thread.start();
        System.out.println("main 结束");
    }
}
