package com.example;

import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.UrlBase64;

/**
 * Created by Zong on 2017/2/3.
 */
public class BCTest {
    public static void main(String[] args) {
        String s = "http://www.baidu.com";
        // 使用bouncycastle进行base64转码
        byte[] bytes = s.getBytes();
        String bcurlsafe = new String(UrlBase64.encode(bytes));
        System.out.println("bouncycastle UrlBase64 : " + bcurlsafe);
        String bcurl = new String(Base64.encode(bytes));
        System.out.println("bouncycastle Base64 : " + bcurl);

        // apache的base64转码最后会出现等号
        String aurl = new String(org.apache.commons.codec.binary.Base64.encodeBase64(bytes));
        System.out.println("apache Base64 : " + aurl);
        String aurlsafe = new String(org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString(bytes));
        System.out.println("apache Base64 : " + aurlsafe);

        // 使用bouncycastle的base64转码，仍然可以使用apache的base64解码
        System.out.println(new String(org.apache.commons.codec.binary.Base64.decodeBase64(bcurlsafe.getBytes())));
        System.out.println(new String(org.apache.commons.codec.binary.Base64.decodeBase64(bcurl.getBytes())));

        // 使用apache的base64转码，仍然可以使用bouncycastle的base64解码
        System.out.println(new String(Base64.decode(aurl)));
        // 但使用apache的base64转码，不可以使用bouncycastle的base64解码
        System.out.println(new String(Base64.decode(aurlsafe)));

//        =====================OutPut=====================
//        bouncycastle UrlBase64 : aHR0cDovL3d3dy5iYWlkdS5jb20.
//        bouncycastle Base64 : aHR0cDovL3d3dy5iYWlkdS5jb20=
//        apache Base64 : aHR0cDovL3d3dy5iYWlkdS5jb20=
//        apache Base64 : aHR0cDovL3d3dy5iYWlkdS5jb20
//        http://www.baidu.com
//        http://www.baidu.com
//        http://www.baidu.com
//        http://www.baidu.c���
    }
}
