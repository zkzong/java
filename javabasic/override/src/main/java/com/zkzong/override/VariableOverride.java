package com.zkzong.override;

import org.junit.Test;

/**
 * Created by Zong on 2016/12/4.
 * 局部变量覆盖问题
 */
public class VariableOverride {
    static {
        // 在第一次被载入JVM时执行，但由于是局部变量，x=5不影响后面的值
        int x = 5;
    }

    static int x, y; // 初始化时x=0，y=0

    public static void main(String[] args) {
        x--;
        myMethod(); // 执行之后x=1，y=0
        System.out.println(x + y++ + x); // 1+0+1=2
    }

    private static void myMethod() {
        y = x++ + ++x; // -1 + 1 = 0
    }

    @Test
    public void jpp() {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++; // 每次都是把0赋值给j
        }
        System.out.println(j); // 0
    }
}
