package com.zkzong.apache.commons.lang;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

/**
 * Created by Zong on 2017/5/12.
 */
public class RandomStringUtilsTest {
    @Test
    public void test() {
        // 生成指定长度的数字字符串
        String num = RandomStringUtils.randomNumeric(5);
        System.out.println(num);

        // 生成指定长度的字母字符串
        String alpha = RandomStringUtils.randomAlphabetic(5);
        System.out.println(alpha);

        // 生成指定长度的字母数字字符串
        String alphanum = RandomStringUtils.randomAlphanumeric(5);
        System.out.println(alphanum);
    }
}
