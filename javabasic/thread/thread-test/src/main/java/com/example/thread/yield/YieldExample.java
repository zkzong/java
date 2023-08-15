package com.example.thread.yield;

public class YieldExample {
    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

//        producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
//        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        producer.start();
        consumer.start();
    }
}

class Producer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am Producer : Produced Item " + i);
            Thread.yield();
        }
    }
}

class Consumer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}

// 没有调用yield()方法情况下的输出
//I am Consumer : Consumed Item 0
//I am Consumer : Consumed Item 1
//I am Consumer : Consumed Item 2
//I am Consumer : Consumed Item 3
//I am Consumer : Consumed Item 4
//I am Producer : Produced Item 0
//I am Producer : Produced Item 1
//I am Producer : Produced Item 2
//I am Producer : Produced Item 3
//I am Producer : Produced Item 4


// 调用yield()方法情况下的输出，去掉优先级
//I am Producer : Produced Item 0
//I am Consumer : Consumed Item 0
//I am Producer : Produced Item 1
//I am Consumer : Consumed Item 1
//I am Producer : Produced Item 2
//I am Consumer : Consumed Item 2
//I am Producer : Produced Item 3
//I am Consumer : Consumed Item 3
//I am Producer : Produced Item 4
//I am Consumer : Consumed Item 4
