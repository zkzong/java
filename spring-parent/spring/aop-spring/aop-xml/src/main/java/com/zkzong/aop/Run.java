package com.zkzong.aop;

/**
 * @Author: zong
 * @Date: 2019.1.11
 */
public class Run {
    public int add(int i, int j) {
        int result = 0;
        result = i + j;
        return result;
    }

    public int div(int i, int j) {
        int result = 0;
        result = i / j;
        return result;
    }
}
