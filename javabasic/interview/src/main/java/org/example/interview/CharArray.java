package org.example.interview;

/**
 * Created by Zong on 2016/12/4.
 */
public class CharArray {
    public static void main(String[] args) {
        char[] c = {'h', 'e', 'l', 'l', 'o'};
        char[] cc = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(c == cc); // false
        System.out.println(c.equals(cc)); // false
        /*
        String重写了equals方法
         */
    }
}
