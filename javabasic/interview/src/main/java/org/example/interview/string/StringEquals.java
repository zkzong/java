package com.example.interview.string;

import org.junit.Test;

/**
 * Created by Zong on 2016/12/4.
 */
public class StringEquals {
    @Test
    public void equals1() {
        String s1 = new String("777");
        String s2 = "aaa777";
        String s3 = "aaa" + "777";
        String s4 = "aaa" + s1;
        System.out.println(s2 == s3); // true
        System.out.println(s2 == s4); // false
        System.out.println(s2 == s4.intern()); // true
        /*
        由于进行连接的两个字符串都是常量，编译期就能确定连接后的值了，
        编译器会进行优化，直接把他们表示成“aaa777”存储到常量池中，
        由于上边的s2="aaa777"已经在常量池中加入了"aaa777"，此句会把s3指向和s2相同的对象，
        所以他们引用相同。此时仍然会创建出"aaa"和"777"两个常量，存储到常量池中
        由于s1是变量，在编译期不能确定它的值是多少，所以会在执行的时候创建一个新的String对象存储到heap中，然后赋值给s4
         */
    }

    @Test
    public void intern() {
        String s1 = new String("aaa777");
        s1 = s1.intern();
        String s2 = "aaa777";
        System.out.println(s1 == s2); // true
        /*
        当调用intern方法时，如果常量池中已经包含一个等于此String对象的字符串（用equals(Object)确定），
        则返回池中的字符串，否则将此String对象添加到池中，并返回此String对象在常量池中的引用
         */
    }
}
