package com.example.thinkinginjava.generics.coffee;

/**
 * Created by Zong on 2016/8/27.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
