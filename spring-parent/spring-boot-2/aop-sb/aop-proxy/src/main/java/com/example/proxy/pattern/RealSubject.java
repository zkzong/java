package com.example.proxy.pattern;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real subject execute request");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
