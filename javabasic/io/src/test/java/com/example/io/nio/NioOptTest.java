package com.example.io.nio;

import org.junit.Test;

import java.io.IOException;

/**
 * @Author: Zong
 * @Date: 2018/12/9
 */
public class NioOptTest {

    @Test
    public void ioRead() throws IOException {
        NioOpt test = new NioOpt();
        String file = "file/github.txt";
        long t1 = System.currentTimeMillis();
        test.ioRead(file);
        long t2 = System.currentTimeMillis();

        System.out.println(t2 - t1);
    }

    @Test
    public void nioRead() throws IOException {
        NioOpt test = new NioOpt();
        String file = "file/github.txt";
        long t1 = System.currentTimeMillis();
        test.nioRead(file);
        long t2 = System.currentTimeMillis();

        System.out.println(t2 - t1);
    }
}