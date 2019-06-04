package com.zkzong.test;

import org.junit.Test;

/**
 * Created by Zong on 2016/11/14.
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(20);
//        Integer i1 = 10;
//        Integer i2 = 20;
        if (i1 > i2) {
            System.out.println("dayu");
        } else {
            System.out.println("xiaoyu");
        }

    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println((Integer) i);
        }
    }
}
