package com.example.apache.commons.codec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by Zong on 2017/1/16.
 */
public class CodecTest {

    @Test
    public void base64() throws UnsupportedEncodingException {
        String s = "宗mohanm4325432wdsfdfhjtyjdzckllsdopeiqpewmlffobile=123434322+/";
        byte[] encode = Base64.encodeBase64(s.getBytes("UTF-8"));
        System.out.println(new String(encode, "UTF-8"));

        byte[] decode = Base64.decodeBase64(encode);
        System.out.println(new String(decode, "UTF-8"));

        System.out.println("=======url safe======");
        String safeEncode = Base64.encodeBase64URLSafeString(s.getBytes("UTF-8"));
        System.out.println(safeEncode);
        System.out.println(new String(Base64.decodeBase64(safeEncode)));

    }
}
