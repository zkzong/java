package org.example.thinkinginjava.generics;

/**
 * Created by Zong on 2016/8/26.
 */
class Automobile {
}

public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}
