package com.example.test.inner;

/**
 * Created by Zong on 2017/5/11.
 */
public class OuterClassTest {
    public static void main(String[] args) {
        new OuterClass().new InnerAbstractClass() {
            @Override
            public void absMethod() {

            }
        };
    }
}
