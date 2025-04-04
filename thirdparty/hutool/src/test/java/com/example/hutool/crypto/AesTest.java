package com.example.hutool.crypto;

import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import org.junit.Test;

public class AesTest {

    /**
     * aes密钥必须是16位
     */
    AES aes = SecureUtil.aes("keyskeyskeyskeys".getBytes());

    @Test
    public void aes() {
        String encryptStr = aes.encryptHex("data");
        System.out.println(encryptStr);
        String decryptStr = aes.decryptStr(encryptStr);
        System.out.println(decryptStr);

        aes = new AES(Mode.CBC, Padding.PKCS5Padding, "keyskeyskeyskeys".getBytes(), "keyskeyskeyskeys".getBytes());
        encryptStr = aes.encryptHex("data");
        System.out.println(encryptStr);
        decryptStr = aes.decryptStr(encryptStr);
        System.out.println(decryptStr);
    }
}
