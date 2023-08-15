package com.example.innerclass;

/**
 * Created by Zong on 2016/7/27.
 * 匿名内部类
 */
public class AnonymousInnerClass {
    //当所在方法的形参需要被匿名内部类使用，那么这个形参就必须为final
    public InnerClass getInnerClass(final int num, String str) {
        return new InnerClass() {
            int number = num + 3;

            @Override
            public int getNumber() {
                return number;
            }
        };
    }

    public static void main(String[] args) {
        AnonymousInnerClass out = new AnonymousInnerClass();
        InnerClass inner = out.getInnerClass(2, "zong");
        System.out.println(inner.getNumber());
    }
}

interface InnerClass {
    int getNumber();
}
