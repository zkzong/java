package com.zkzong.interview;

/**
 * Created by Zong on 2016/12/4.
 */
class Bases {
    int i;

    public Bases() {
        add(1);
        System.out.println(i);
    }

    void add(int v) {
        i += v;
        System.out.println(i);
    }

    void print() {
        System.out.println(i);
    }
}

class MyBase extends Bases {
    public MyBase() {
        add(2);
    }

    @Override
    void add(int v) {
        i += v * 2;
        System.out.println(i);
    }
}

public class MethodInvoke {
    public static void main(String[] args) {
        go(new MyBase()); // 22
    }

    static void go(Bases b) {
        b.add(8);
    }
}
/*
先调用Bases的构造方法，执行add(1)，但这个add方法会调用MyBase中的add方法
1. i=i+v*2=0+1*2=2
2. i=2+2*2=6
3. i=6+8*2=22
 */
