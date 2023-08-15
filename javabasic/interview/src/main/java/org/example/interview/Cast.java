package com.example.interview;

import org.junit.Test;

/**
 * Created by Zong on 2016/12/4.
 * 向上转型
 */
public class Cast {
    @Test
    public void cast() {
        char x = 'x';
        int i = 10;
        // 一个int，一个char，向上转型为int
        System.out.println(false ? i : x); // 120
        // 10是常量，可以被char表示
        System.out.println(false ? 10 : x); // x
    }
}
