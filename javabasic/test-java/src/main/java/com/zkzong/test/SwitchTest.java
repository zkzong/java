package com.zkzong.test;

import org.junit.Test;

/**
 * Created by Zong on 2016/12/17.
 */
public class SwitchTest {
    @Test
    public void test() {
        int c = 0, k;
        for (k = 1; k < 3; k++) {
            switch (k) {
                default:
                    c += k;
                case 2:
                    c++;
                    break;
                case 4:
                    c += 2;
                    break;
            }
        }
        System.out.println("c = " + c);
    }
}
