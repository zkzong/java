package org.example.interview.string;

import org.junit.Test;

/**
 * Created by Zong on 2016/12/4.
 */
public class ChangeValue {
    static String str;

    public static void method() {
        str = "Good-bye";
    }

    @Test
    public void test1() {
        str = "abcd";
        method();
        System.out.println(str); // Good-bye
    }

    @Test
    public void test2() {
        String str = "abcd";
        method();
        System.out.println(str); // abcd
    }
}
