package com.zkzong.interview.string;

/**
 * Created by Zong on 2016/12/6.
 */
public class ChangeValue1 {
    public static void main(String[] args) {
        String s = "hello";
        ChangeValue1 cv = new ChangeValue1();
        cv.modify(s);
        System.out.println(s);

        // output :
        // hello world
        // hello
    }

    public void modify(String s) {
        s = s + " world";
        System.out.println(s);
    }
}
