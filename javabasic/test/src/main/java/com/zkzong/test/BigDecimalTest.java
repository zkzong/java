package com.zkzong.test;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        double doubleVal = 1.745;
        double doubleVal1 = 0.745;
        BigDecimal bdTest = new BigDecimal(doubleVal);
        BigDecimal bdTest1 = new BigDecimal(doubleVal1);
        bdTest = bdTest.setScale(2, BigDecimal.ROUND_HALF_UP);
        bdTest1 = bdTest1.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("bdTest:" + bdTest); // 1.75
        System.out.println("bdTest1:" + bdTest1); // 0.74
        // 使用参数为float或double的BigDecimal创建对象会丢失精度。
        // 因此强烈建议不要使用参数为float或double的BigDecimal创建对象。


        // 1. 使用BigDecimal(String val)的构造方法创建对象
        System.out.println(new BigDecimal("1.745"));
        System.out.println(new BigDecimal("0.745"));
        // 2. 使用使用BigDecimal的valueOf(double val)方法创建对象
        System.out.println(BigDecimal.valueOf(1.745));
        System.out.println(BigDecimal.valueOf(0.745));
    }
}
