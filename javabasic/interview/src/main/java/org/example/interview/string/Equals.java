package org.example.interview.string;

/**
 * Created by Zong on 2016/12/4.
 */
public class Equals {
    public static void main(String[] args) {
        String s = "hello";
//        String t = "hello";
        String str = "hello";
        char[] c = {'h', 'e', 'l', 'l', 'o'};
        char[] ch = str.toCharArray();
        System.out.println(ch == c); // false
        System.out.println(ch.equals(ch.equals(c))); // false

        String s2 = new String(c);
        System.out.println(s2 == s); // false
        System.out.println(s2.equals(s)); // true
    }
}
