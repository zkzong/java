package com.example.other;

import java.io.UnsupportedEncodingException;

public class StrLength {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("宗：" + count("宗"));
        System.out.println("a：" + count("a"));

        System.out.println("宗".length());
        System.out.println("a".length());

        System.out.println("宗".getBytes("gbk").length);
        System.out.println("a".getBytes("gbk").length);
    }

    public static int count(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int count = 0;
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            count += (chs[i] > 0xff) ? 2 : 1;
        }
        return count;
    }
}
