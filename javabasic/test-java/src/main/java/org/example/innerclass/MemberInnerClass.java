package com.example.innerclass;

/**
 * Created by Zong on 2016/7/27.
 * 成员内部类
 * 成员内部类可以无限制的访问外围类的所有 成员属性和方法，尽管是private的，
 * 但是外围类要访问内部类的成员属性和方法则需要通过内部类实例来访问。
 */
public class MemberInnerClass {
    private String str;

    public void outerDisplay() {
        System.out.println("outerClass...");
    }

    public class InnerClass {
        public void innerDisplay() {
            //使用外围内的属性
            str = "zong";
            System.out.println(str);
            //使用外围内的方法
            outerDisplay();
        }
    }

    /*推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时*/
    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    public static void main(String[] args) {
        MemberInnerClass outer = new MemberInnerClass();
        MemberInnerClass.InnerClass inner = outer.getInnerClass();
        inner.innerDisplay();
    }
}
