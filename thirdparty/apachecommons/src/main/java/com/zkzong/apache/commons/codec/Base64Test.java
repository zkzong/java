package com.zkzong.apache.commons.codec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class Base64Test {

    @Test
    public void apache() throws UnsupportedEncodingException {
        long start = System.currentTimeMillis();
        final Base64 base64 = new Base64();
        final String text = "Java技术栈";
        final byte[] textByte = text.getBytes("UTF-8");

        //编码
        final String encodedText = base64.encodeToString(textByte);
        System.out.println(encodedText);

        //解码
        System.out.println(new String(base64.decode(encodedText), "UTF-8"));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    @Test
    public void jdk8() throws UnsupportedEncodingException {
        long start = System.currentTimeMillis();
        final java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        final java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        final String text = "Java技术栈";
        final byte[] textByte = text.getBytes("UTF-8");

        //编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);

        //解码
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
