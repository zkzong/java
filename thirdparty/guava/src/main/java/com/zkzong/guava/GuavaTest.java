package com.zkzong.guava;

import com.google.common.base.Optional;

/**
 * Created by zong on 2016/8/10.
 */
public class GuavaTest {
    public static void main(String[] args) {
        GuavaTest guavaTest = new GuavaTest();

//        Integer a = null;
//        Integer b = new Integer(10);
//        System.out.println(guavaTest.sum(a, b));

        Integer invalidInput = null;
        Optional<Integer> a = Optional.of(invalidInput);
        Optional<Integer> b = Optional.of(Integer.valueOf(10));
        System.out.println(guavaTest.sum(a, b));
    }

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        return a.get() + b.get();
    }
}
