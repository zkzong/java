package org.example.thinkinginjava.generics;

/**
 * Created by Zong on 2016/8/26.
 */
public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
        Automobile a = h3.get(); // No cast needed
//        h3.set("Not an automobile"); // Error
//        h3.set(1); // Error

        Holder3<Integer> h = new Holder3<Integer>(3);
        System.out.println(h.get());
    }
}
