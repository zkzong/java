package com.example.innerclass;

/**
 * Created by Zong on 2016/7/27.
 */
public class OuterClass1<T> {
    public OuterClass1() {
    }

    public OuterClass1(T t) {

    }

    public void display() {
        System.out.println("OuterClass1...");
    }

    public class InnerClass {
        public OuterClass1 getOuterClass1() {
            return OuterClass1.this;
        }
    }

    public abstract class InnerAbstractClass {
        public void a() {

        }

        public abstract void absMethod();
    }

    public abstract class TT {
        public void t() {
        }
    }

    public static void main(String[] args) {
        OuterClass1 outerClass1 = new OuterClass1();
        OuterClass1.InnerClass innerClass = outerClass1.new InnerClass();
        innerClass.getOuterClass1().display();

//        new OuterClass1<String>().new TT();

//        new OuterClass1<String>().new InnerAbstractClass();
        new OuterClass1<String>().new InnerAbstractClass() {
            @Override
            public void absMethod() {

            }
        };
    }
}
