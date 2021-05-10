package com.zkzong.exception;

import org.junit.Test;

/**
 * Created by Zong on 2016/7/14.
 */
public class TryCatch {
    @Test
    public void test1() {
        /**
         * 异常被catch之后，后面的代码会继续执行
         */
        int t = 10;
        try {
            throw new Exception();
        } catch (Exception e) {
            t = 11;
            e.printStackTrace();
//            throw new Exception();
        }
        System.out.println(t); // 11
        System.out.println("继续执行");
    }

    @Test
    public void test2() {
        String s = s();
        System.out.println(s);
    }

    private String s() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "a";
    }

    @Test
    public void test3() {
        String ss = ss();
        System.out.println(ss);
    }

    private String ss() {
        try {
            throw new Exception();
        } catch (Exception e) {
            return "catch";
        } finally {
            return "finally";
        }
    }
}
