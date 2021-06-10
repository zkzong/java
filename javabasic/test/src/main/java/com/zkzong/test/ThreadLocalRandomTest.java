package com.zkzong.test;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {

    @Test
    public void random() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int i = random.nextInt();
        System.out.println(i);
    }
}
