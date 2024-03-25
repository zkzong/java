package com.example.hutool.util;

import cn.hutool.core.util.NumberUtil;
import org.junit.Test;

public class NumberUtilTest {

    @Test
    public void isLong() {
        boolean b = NumberUtil.isLong("123456");
        System.out.println(b);
    }

    @Test
    public void intTest() {
        boolean b = NumberUtil.isInteger("1");
        System.out.println(b);

        Integer i = NumberUtil.toBigInteger("-10").intValue();
        System.out.println(i);
    }
}
