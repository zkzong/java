package com.zkzong.hutool.crypto;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.SM2;
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
    public void en() {
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
     * todo 使用自定义的公私钥
     * 签名、签名验证
     */
    @Test
    public void sign() {
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJS0X4+zz+OeIari1JpLmq8mOeIubZXfAa+an7GS/abM/EMmZ9resjLeE/QnHGPZqDDRVVYpYHv9Qa7/m0PGwX/99fNzc7088pODjIZ464AOA69zwYcmmhyCch+kQyJLZV2IbXcy5banV0jYQ50w5y9wGi0O3igRQhrViV3K9RALAgMBAAECgYEAhTddkKgeaiRktulEWwG2DoipPFYpeCTzJrTXsUYklER5DVMfoPT2IRnQOF69UTpRMYKm92xT8l+8cyCroLky6LAoVTbekeY2MWQ8ljW9rTwQBGDKe8O09A83ca0CA/9b/etnS29wWUtQnGLOY5cPX6YjCG2zzMSR72n/WvJzWdkCQQDFVm42rITeYCdePPJLag9Y8f1yCGKk074jdKmu2LW9tGQn3/YHKAwtuzp5eSMs4IeXAOq488ukKtCjw3uLRoo9AkEAwOjs2NKbJkiunOgJRNjWzA9jBR281IxoWwHD0J/fggTKsHNh6akthszPd1czV2MdFRJ7DltezQhpk3sDOhPP5wJAfHRKBgk/ss+JhJGDbbRyAXJ8mRJYxAMWg13sNe1OkVnXYJ6Kl3DWXXEbK8kOOhtQ6BcX8ZUv9VVbSCzdGbVfMQJBAKp/c43zHiNJC+MsBb0utTGny8mizdlBu53rwmiqVH3yxD4NzJUa7Fz+ucLtdDghJnwQWGiJAxHOBJnPmDuFdTMCQEpx7IHtVsWjNd0gkcErvvu2IuHdlvhUgKOb6vQUVFKFDMfUq7cNisOSVf/A5T/1IgB3r/GLE6fHj9YEDmCCgo8=MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCUtF+Ps8/jniGq4tSaS5qvJjniLm2V3wGvmp+xkv2mzPxDJmfa3rIy3hP0Jxxj2agw0VVWKWB7/UGu/5tDxsF//fXzc3O9PPKTg4yGeOuADgOvc8GHJpocgnIfpEMiS2VdiG13MuW2p1dI2EOdMOcvcBotDt4oEUIa1YldyvUQCwIDAQAB";
        String publicKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANx7qOCc2ZEslkhLGCXVn5YLWWnauUEuyP1/wunFhAjyjLF87MJXOWTy2kPHCuySDYC1xtttxxvWHd+tpA6OlUaD3DJrCVqOvxcYgqib/zr7v7peFzZS/swuqBrdwcR55SkTlZKXuR++BeSSD2Q35Oe4pOtWWY4gCDCxGeFn1AIHAgMBAAECgYBnz42HHDLQSMcFiN34ymlWU0epMIOzLh0SRnp2aTouoE0gMGqlYj4yyql76ha5plbXOD9GB50M/TaZn380H2wmpBhsdU0QGSlRu0XqqjrfIOXr8sVXmZx9jxFNy15p9nTYUugZNVL9NYJAxwxSDvA1jbvsnPKdEjqGYjg6tl8wEQJBAP9BKp5vJmpZ+eNhrQlsMqXzr4837vjsjaIeTYpPwyitD8CQ3O5K1R0sdX9Upxzgyrl1vMR7q0eal83wKG1gnTkCQQDdIH9PaiXjH86xxIEElAAQy8crrk1ols9fm0I5WgSHbdHLnEQffGyOYtw73KL6bQQu1aDelMD26YXVMfYeCNk/AkEA9fclymXw7qqlUabdxyar555anfeYH+ZS1NW+gnk55gheFYGCY11Y3zPoRTqdjgZPU0dRD0TcV7NwdNHnIv7mgQJBANHztg0f+uMgYy8UJW/EWh+Ya/5EW8kPT8w17PXpS12O3uBU+bVvfN7gbL0Fq1Tcx1j0iu5rDKAjb2fSLR2tRx8CQQCO4kZowo4WVkUcK0IA3D2V8m6dy/neNGS1KQLfPIt+z8ZZgTQMznG843VGK7dY10OYz/yiA50gwZLfkGecNXUkMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDce6jgnNmRLJZISxgl1Z+WC1lp2rlBLsj9f8LpxYQI8oyxfOzCVzlk8tpDxwrskg2Atcbbbccb1h3fraQOjpVGg9wyawlajr8XGIKom/86+7+6Xhc2Uv7MLqga3cHEeeUpE5WSl7kfvgXkkg9kN+TnuKTrVlmOIAgwsRnhZ9QCBwIDAQAB";

        String data = "zong";

        Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA);
        byte[] bytes = sign.sign(data.getBytes(StandardCharsets.UTF_8));
        //System.out.println(HexUtil.encodeHex(bytes));
        boolean verify = sign.verify(data.getBytes(StandardCharsets.UTF_8), bytes);
        System.out.println(verify);
    }

    @Test
    public void s() {
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJS0X4+zz+OeIari1JpLmq8mOeIubZXfAa+an7GS/abM/EMmZ9resjLeE/QnHGPZqDDRVVYpYHv9Qa7/m0PGwX/99fNzc7088pODjIZ464AOA69zwYcmmhyCch+kQyJLZV2IbXcy5banV0jYQ50w5y9wGi0O3igRQhrViV3K9RALAgMBAAECgYEAhTddkKgeaiRktulEWwG2DoipPFYpeCTzJrTXsUYklER5DVMfoPT2IRnQOF69UTpRMYKm92xT8l+8cyCroLky6LAoVTbekeY2MWQ8ljW9rTwQBGDKe8O09A83ca0CA/9b/etnS29wWUtQnGLOY5cPX6YjCG2zzMSR72n/WvJzWdkCQQDFVm42rITeYCdePPJLag9Y8f1yCGKk074jdKmu2LW9tGQn3/YHKAwtuzp5eSMs4IeXAOq488ukKtCjw3uLRoo9AkEAwOjs2NKbJkiunOgJRNjWzA9jBR281IxoWwHD0J/fggTKsHNh6akthszPd1czV2MdFRJ7DltezQhpk3sDOhPP5wJAfHRKBgk/ss+JhJGDbbRyAXJ8mRJYxAMWg13sNe1OkVnXYJ6Kl3DWXXEbK8kOOhtQ6BcX8ZUv9VVbSCzdGbVfMQJBAKp/c43zHiNJC+MsBb0utTGny8mizdlBu53rwmiqVH3yxD4NzJUa7Fz+ucLtdDghJnwQWGiJAxHOBJnPmDuFdTMCQEpx7IHtVsWjNd0gkcErvvu2IuHdlvhUgKOb6vQUVFKFDMfUq7cNisOSVf/A5T/1IgB3r/GLE6fHj9YEDmCCgo8=MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCUtF+Ps8/jniGq4tSaS5qvJjniLm2V3wGvmp+xkv2mzPxDJmfa3rIy3hP0Jxxj2agw0VVWKWB7/UGu/5tDxsF//fXzc3O9PPKTg4yGeOuADgOvc8GHJpocgnIfpEMiS2VdiG13MuW2p1dI2EOdMOcvcBotDt4oEUIa1YldyvUQCwIDAQAB";
        String publicKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANx7qOCc2ZEslkhLGCXVn5YLWWnauUEuyP1/wunFhAjyjLF87MJXOWTy2kPHCuySDYC1xtttxxvWHd+tpA6OlUaD3DJrCVqOvxcYgqib/zr7v7peFzZS/swuqBrdwcR55SkTlZKXuR++BeSSD2Q35Oe4pOtWWY4gCDCxGeFn1AIHAgMBAAECgYBnz42HHDLQSMcFiN34ymlWU0epMIOzLh0SRnp2aTouoE0gMGqlYj4yyql76ha5plbXOD9GB50M/TaZn380H2wmpBhsdU0QGSlRu0XqqjrfIOXr8sVXmZx9jxFNy15p9nTYUugZNVL9NYJAxwxSDvA1jbvsnPKdEjqGYjg6tl8wEQJBAP9BKp5vJmpZ+eNhrQlsMqXzr4837vjsjaIeTYpPwyitD8CQ3O5K1R0sdX9Upxzgyrl1vMR7q0eal83wKG1gnTkCQQDdIH9PaiXjH86xxIEElAAQy8crrk1ols9fm0I5WgSHbdHLnEQffGyOYtw73KL6bQQu1aDelMD26YXVMfYeCNk/AkEA9fclymXw7qqlUabdxyar555anfeYH+ZS1NW+gnk55gheFYGCY11Y3zPoRTqdjgZPU0dRD0TcV7NwdNHnIv7mgQJBANHztg0f+uMgYy8UJW/EWh+Ya/5EW8kPT8w17PXpS12O3uBU+bVvfN7gbL0Fq1Tcx1j0iu5rDKAjb2fSLR2tRx8CQQCO4kZowo4WVkUcK0IA3D2V8m6dy/neNGS1KQLfPIt+z8ZZgTQMznG843VGK7dY10OYz/yiA50gwZLfkGecNXUkMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDce6jgnNmRLJZISxgl1Z+WC1lp2rlBLsj9f8LpxYQI8oyxfOzCVzlk8tpDxwrskg2Atcbbbccb1h3fraQOjpVGg9wyawlajr8XGIKom/86+7+6Xhc2Uv7MLqga3cHEeeUpE5WSl7kfvgXkkg9kN+TnuKTrVlmOIAgwsRnhZ9QCBwIDAQAB";

        String data = "zong";

        SM2 sm2 = new SM2(privateKey, publicKey);
        byte[] sign = sm2.sign(data.getBytes(StandardCharsets.UTF_8));
        boolean verify = sm2.verify(data.getBytes(StandardCharsets.UTF_8), sign);
        System.out.println(verify);
    }
}
