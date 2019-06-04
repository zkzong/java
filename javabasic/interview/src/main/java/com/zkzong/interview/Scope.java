package com.zkzong.interview;

/**
 * Created by Zong on 2016/12/4.
 */
public class Scope {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Integer k = new Integer(i);
        }

//        for (int i = 0; i < 10; i++)
//            int k = new Integer(i);
    }
}
