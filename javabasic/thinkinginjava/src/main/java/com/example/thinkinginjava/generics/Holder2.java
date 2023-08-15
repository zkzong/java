package com.example.thinkinginjava.generics;

/**
 * Created by Zong on 2016/8/26.
 */
public class Holder2 {
    private Object a;

    public Holder2(Object a) {
        this.a = a;
    }

    public Object get() {
        return a;
    }

    public void set(Object a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile) h2.get();
        h2.set("Not an automobile");

        String s = (String) h2.get();
        h2.set(1);
        Integer x = (Integer) h2.get();
    }
}
