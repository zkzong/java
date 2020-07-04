package com.zkzong.aop;

import org.springframework.stereotype.Component;

/**
 * @Author: zong
 * @Date: 2019.1.11
 */
@Component
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
