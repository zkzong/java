package com.zkzong.hutool.crypto;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;

/**
 * @Author: zong
 * @Date: 2021/8/5
 */
public class RsaTest {

    /**
     * 自助生成密钥对
     */
    @Test
    public void generate() {
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        final String pv = Base64.encode(pair.getPrivate().getEncoded());
        final String pb = Base64.encode(pair.getPublic().getEncoded());
        System.out.println(pv);
        System.out.println(pb);

        RSA rsa = new RSA();
        // 获得私钥
        rsa.getPrivateKey();
        final String privateKeyBase64 = rsa.getPrivateKeyBase64();
        System.out.println(privateKeyBase64);
        // 获得公钥
        rsa.getPublicKey();
        final String publicKeyBase64 = rsa.getPublicKeyBase64();
        System.out.println(publicKeyBase64);

        // 公钥加密，私钥解密
        byte[] encrypt = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
        // 加密后字符串
        final String en1 = Base64.encode(encrypt);
        System.out.println(en1);
        // 解密后二进制
        byte[] decrypt = rsa.decrypt(en1, KeyType.PrivateKey);
        // 解密后字符串
        final String s = new String(decrypt);
        System.out.println(s);

        // 私钥加密，公钥解密
        byte[] encrypt2 = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
        byte[] decrypt2 = rsa.decrypt(encrypt2, KeyType.PublicKey);
    }

    /**
     * 已知私钥和密文，解密密文
     */
    @Test
    public void decrypt() {
        String PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIL7pbQ+5KKGYRhw7jE31hmA"
                + "f8Q60ybd+xZuRmuO5kOFBRqXGxKTQ9TfQI+aMW+0lw/kibKzaD/EKV91107xE384qOy6IcuBfaR5lv39OcoqNZ"
                + "5l+Dah5ABGnVkBP9fKOFhPgghBknTRo0/rZFGI6Q1UHXb+4atP++LNFlDymJcPAgMBAAECgYBammGb1alndta"
                + "xBmTtLLdveoBmp14p04D8mhkiC33iFKBcLUvvxGg2Vpuc+cbagyu/NZG+R/WDrlgEDUp6861M5BeFN0L9O4hz"
                + "GAEn8xyTE96f8sh4VlRmBOvVdwZqRO+ilkOM96+KL88A9RKdp8V2tna7TM6oI3LHDyf/JBoXaQJBAMcVN7fKlYP"
                + "Skzfh/yZzW2fmC0ZNg/qaW8Oa/wfDxlWjgnS0p/EKWZ8BxjR/d199L3i/KMaGdfpaWbYZLvYENqUCQQCobjsuCW"
                + "nlZhcWajjzpsSuy8/bICVEpUax1fUZ58Mq69CQXfaZemD9Ar4omzuEAAs2/uee3kt3AvCBaeq05NyjAkBme8SwB0iK"
                + "kLcaeGuJlq7CQIkjSrobIqUEf+CzVZPe+AorG+isS+Cw2w/2bHu+G0p5xSYvdH59P0+ZT0N+f9LFAkA6v3Ae56OrI"
                + "wfMhrJksfeKbIaMjNLS9b8JynIaXg9iCiyOHmgkMl5gAbPoH/ULXqSKwzBw5mJ2GW1gBlyaSfV3AkA/RJC+adIjsRGg"
                + "JOkiRjSmPpGv3FOhl9fsBPjupZBEIuoMWOC8GXK/73DHxwmfNmN7C9+sIi4RBcjEeQ5F5FHZ";

        RSA rsa = new RSA(PRIVATE_KEY, null);

        String a = "2707F9FD4288CEF302C972058712F24A5F3EC62C5A14AD2FC59DAB93503AA0FA17113A020EE4EA35EB53F"
                + "75F36564BA1DABAA20F3B90FD39315C30E68FE8A1803B36C29029B23EB612C06ACF3A34BE815074F5EB5AA3A"
                + "C0C8832EC42DA725B4E1C38EF4EA1B85904F8B10B2D62EA782B813229F9090E6F7394E42E6F44494BB8";

        byte[] aByte = HexUtil.decodeHex(a);
        byte[] decrypt = rsa.decrypt(aByte, KeyType.PrivateKey);
        System.out.println(new String(decrypt));

        //Junit单元测试
        Assert.assertEquals("虎头闯杭州,多抬头看天,切勿只管种地", StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));
    }

    /**
     * 使用自定义的公私钥
     * 签名、签名验证
     */
    @Test
    public void sign() {
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        final String pv = Base64.encode(pair.getPrivate().getEncoded());
        final String pb = Base64.encode(pair.getPublic().getEncoded());
        System.out.println(pv);
        System.out.println(pb);

        String data = "zong";

        // 使用自定义的公私钥签名
        Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA, pv, pb);
        // 使用默认的公私钥签名
        //Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA);
        byte[] bytes = sign.sign(data.getBytes(StandardCharsets.UTF_8));
        //System.out.println(HexUtil.encodeHex(bytes));
        boolean verify = sign.verify(data.getBytes(StandardCharsets.UTF_8), bytes);
        System.out.println(verify);
    }

}
