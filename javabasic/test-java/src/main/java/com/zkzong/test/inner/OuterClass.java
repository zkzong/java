package com.zkzong.test.inner;

/**
 * Created by Zong on 2016/7/27.
 */
public class OuterClass<T> {
    public OuterClass() {
    }

    public abstract class InnerAbstractClass {
        public void a() {

        }
        public abstract void absMethod();
    }

    public void test() {
        new OuterClass().new InnerAbstractClass() {
            @Override
            public void absMethod() {

            }
        };
    }

    public static void main(String[] args) {

        new OuterClass().new InnerAbstractClass(){
            @Override
            public void absMethod() {
                System.out.println("out");
            }
        }.absMethod();
    }
}
