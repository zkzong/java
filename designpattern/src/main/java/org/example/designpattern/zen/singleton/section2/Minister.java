package org.example.designpattern.zen.singleton.section2;

/**
 * Created by Zong on 2016/10/13.
 * 臣子类
 */
public class Minister {
    public static void main(String[] args) {
        // 定义5个大臣
        int ministerNum = 5;

        for (int i = 0; i < ministerNum; i++) {
            Emperor emperor = Emperor.getInstance();
            System.out.print("第" + (i + 1) + "个大臣参拜的是：");
            emperor.say();
        }
    }
}
