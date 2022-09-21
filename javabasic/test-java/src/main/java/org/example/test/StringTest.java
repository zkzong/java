package org.example.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * Created by Zong on 2016/10/18.
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println("abc".equals(null)); // false

        System.out.println("hhhhhhhhhh".replace("bb", ""));

        synchronized (Integer.class) {
            System.out.println(Double.parseDouble(""));
        }
    }

    @Test
    public void iter() {
        String str = "Tesson.";
        for (int i = 0; i < str.length(); i++) {
            Character item = str.charAt(i);
            System.out.println(item);
        }
    }

    @Test
    public void encode() throws UnsupportedEncodingException {
        String s = "宗";
        System.out.println(new String(s.getBytes(StandardCharsets.UTF_8)));
    }

    @Test
    public void testequals() {
        String s1 = "abc";
        String s2 = "a";
        String s3 = "bc";
        String s4 = s2 + s3;
        System.out.println(s1 == s4);

        System.out.println("O".equals("O"));
    }
}
