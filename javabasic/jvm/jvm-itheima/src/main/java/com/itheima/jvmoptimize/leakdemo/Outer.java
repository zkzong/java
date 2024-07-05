package com.itheima.jvmoptimize.leakdemo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: zongz
 * @Date: 2024/6/22
 */

/**
 * -Xmx10g -Xms10g
 */
public class Outer {
    private byte[] bytes = new byte[1024 * 1024]; //外部类持有数据
    private static String name = "测试";

    static class Inner {
        private String name;

        public Inner() {
            this.name = Outer.name;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //System.in.read();
        int count = 0;
        ArrayList<Inner> inners = new ArrayList<>();
        while (true) {
            if (count++ % 100 == 0) {
                Thread.sleep(10);
            }
            inners.add(new Inner());
        }
    }
}
