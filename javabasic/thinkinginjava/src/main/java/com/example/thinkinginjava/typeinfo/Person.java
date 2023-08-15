package com.example.thinkinginjava.typeinfo;

import com.example.thinkinginjava.util.Null;

/**
 * Created by Zong on 2016/9/20.
 */
public class Person {
    public final String first;
    public final String last;
    public final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class NullPerson extends Person implements Null {
        public NullPerson() {
            super("None", "None", "None");
        }
    }

    public static final Person NULL = new NullPerson();
}
