package com.zkzong.designpattern.zen.singleton.section1;

/**
 * Created by Zong on 2016/10/13.
 * 皇帝类
 */
public class Emperor {
    private static final Emperor emperor = new Emperor(); // 初始化一个皇帝

    private Emperor() {
        // 世俗和道德约束你，目的就是不希望产生第二个皇帝
    }

    public static Emperor getInstance() {
        return emperor;
    }

    // 皇帝发话了
    public static void say() {
        System.out.println("我就是皇帝某某某...");
    }
}
