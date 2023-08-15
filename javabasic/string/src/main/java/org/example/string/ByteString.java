package com.example.string;

import org.junit.Test;

/**
 * @author zkzong
 * @date 2017/10/30
 */
public class ByteString {
    @Test
    public void byte2String() {
        byte[] bytes = "abcd".getBytes();
        System.out.println(bytes.toString()); // [B@50134894
        System.out.println(new String(bytes)); // abcd
        System.out.println(String.valueOf(bytes)); // [B@50134894
    }
}
