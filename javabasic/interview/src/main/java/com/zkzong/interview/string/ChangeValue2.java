package com.zkzong.interview.string;

/**
 * Created by Zong on 2016/12/9.
 */
public class ChangeValue2 {
    private String s = "abc";
    private char[] c = {'e', 'f', 'g'};

    public static void main(String[] args) {
        ChangeValue2 changeValue2 = new ChangeValue2();
        changeValue2.modify(changeValue2.s, changeValue2.c);
        System.out.println(changeValue2.s + " and " + changeValue2.c[0]); // abc and a
    }

    public void modify(String ss, char[] cc) {
        ss = "bcd";
        cc[0] = 'a';
    }
}
