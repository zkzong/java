package org.example.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement()); // 1
        System.out.println(ai.get()); // 2
    }
}
