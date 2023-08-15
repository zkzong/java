package com.example.thinkinginjava.util;

/**
 * Created by Zong on 2016/8/26.
 */
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D fourth;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                '}';
    }
}
