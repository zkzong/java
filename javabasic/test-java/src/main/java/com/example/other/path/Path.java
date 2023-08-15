package com.example.other.path;

import org.junit.Test;

import java.io.File;

/**
 * Created by Zong on 2016/8/3.
 */
public class Path {
    @Test
    public void test() {

        System.out.println(System.getProperty("user.dir"));

        System.out.println(Path.class.getResource(""));

        System.out.println(Path.class.getResource("/"));

        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));

        //推荐使用Thread.currentThread().getContextClassLoader().getResource(“”)来得到当前的classpath的绝对路径的URI表示法。

        System.out.println(Path.class.getClassLoader().getResource(""));

        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));

        System.out.println(ClassLoader.getSystemResource(""));

        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);


    }
}
