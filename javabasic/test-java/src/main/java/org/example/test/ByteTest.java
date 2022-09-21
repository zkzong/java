package org.example.test;

/**
 * Created by Zong on 17/1/9.
 */
public class ByteTest {
    public static void main(String[] args) {
        byte[] bytes = new byte[]{1, 2, 3, 4};
        System.out.println(bytes.length);
        String s = new String(bytes);
        System.out.println(s);
        System.out.println(s.getBytes().length);

        System.out.println("a b c".replace(" ", "+"));

    }
}
