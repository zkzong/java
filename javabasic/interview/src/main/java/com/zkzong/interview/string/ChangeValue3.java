package com.zkzong.interview.string;

public class ChangeValue3 {
    private static String a;
    private static String b;

    public static void main(String[] args) {
        String c = "c";
        String d = "d";
        ChangeValue3 cv = new ChangeValue3();
        
        cv.change(a, b);
        System.out.println("a = " + a + ", b = " + b); // a = null, b = null

        cv.change(c, d);
        System.out.println("c = " + c + ", d = " + d); // c = c, d = d
    }

    private void change(String s1, String s2) {
        s1 = "s1";
        s2 = "s2";
    }
}
