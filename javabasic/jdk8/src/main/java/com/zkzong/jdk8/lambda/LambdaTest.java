package com.zkzong.jdk8.lambda;

import org.junit.Test;

import javax.swing.*;
import java.util.function.Predicate;

/**
 * @Author: zkzong
 * @Date: 2018.9.21
 */
public class LambdaTest {
    @Test
    public void button() {
        JButton jButton = new JButton();
        jButton.addActionListener(e -> System.out.println("按钮被点击了"));
    }

    @Test
    public void run() {
        new Thread(()-> System.out.println("这是个线程，我是匿名内部类")).start();
    }

    @Test
    public void test() {
        Predicate<String> stringFilter = (String s) -> !s.isEmpty();
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        //portNumber = 111;
    }
}
