package com.zkzong.guava;

import org.junit.Test;

/**
 * @Author: zong
 * @Date: 2020/1/9
 */
public class EnumTest {
    @Test
    public void test() {
        ResultEnum[] values = ResultEnum.values();
        for (ResultEnum value : values) {
            if (value.getCode().equals("0000")){
                System.out.println(value);
            }
        }
    }
}
