package com.zkzong;

import org.junit.Test;

/**
 * @Author: Zong
 * @Date: 2018/9/9
 */
public class Ipp {

    @Test
    public void test1() {
        int i = 2;
        int j = i * i++;
        System.out.println(j); // 4
    }

    @Test
    public void test2() {
        int i = 2;
        int j = i * ++i;
        System.out.println(j); // 6
    }
}
