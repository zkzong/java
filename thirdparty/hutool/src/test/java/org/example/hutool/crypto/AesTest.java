package org.example.hutool.crypto;

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
    }
}
