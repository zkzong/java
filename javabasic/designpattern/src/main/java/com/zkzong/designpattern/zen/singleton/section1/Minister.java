package com.zkzong.designpattern.zen.singleton.section1;

/**
 * Created by Zong on 2016/10/13.
 * 臣子类
 */
public class Minister {
    public static void main(String[] args) {
        for (int day = 0; day < 3; day++) {
            Emperor emperor = Emperor.getInstance();
            emperor.say();
        }
    }
}
