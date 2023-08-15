package com.example.hutool.util;

import cn.hutool.core.util.NumberUtil;
import org.junit.Test;

public class NumberUtilTest {

    @Test
    public void isLong() {
        boolean b = NumberUtil.isLong("123456");
        System.out.println(b);
    }
}
