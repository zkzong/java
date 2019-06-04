package com.zkzong.interview;

/**
 * Created by Zong on 2016/11/29.
 */
public class TryReturn {
    public static void main(String[] args) {
        boolean test = test();
        System.out.println(test);
    }

    public static boolean test() {
        boolean flag = true;
        try {
            return flag;
        } finally {
            flag = false;
        }
    }
}
