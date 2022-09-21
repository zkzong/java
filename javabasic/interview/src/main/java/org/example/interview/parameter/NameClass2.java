package org.example.interview.parameter;

/**
 * Created by Zong on 2016/12/4.
 */
public class NameClass2 {
    private static int x;

    public static void main(String[] args) {
        name(x);
        System.out.println(x); // 1
    }

    public static void name(int y) {
        x++;
    }
}
