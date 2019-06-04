package com.zkzong.exception;

/**
 * Created by Zong on 2016/12/10.
 * 堆栈溢出错误一般是递归调用
 */
public class StackOverflowTest {
    public static void main(String[] args) {
        method();
    }

    private static void method() {
        for (; ; ) {
            method();
        }
    }
}
