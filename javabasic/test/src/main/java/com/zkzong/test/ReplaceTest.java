package com.zkzong.test;

import org.junit.Test;

/**
 * Created by zong on 17/1/10.
 */
public class ReplaceTest {
    @Test
    public void test() {
        String s = "abc\\hagjaldf";
        System.out.println(s.replace("\\", "")); // abchagjaldf
    }
}
