package com.spring.cloud.gateway;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.alibaba.fastjson.JSON;
import com.spring.cloud.gateway.req.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AesTest {

    AES aes = SecureUtil.aes("scgatewaygateway".getBytes());

    @Test
    public void encrypt() {
        Map map = new HashMap<>();
        map.put("id", 1);
        String s = aes.encryptHex(map.toString());
        System.out.println(s);


        User user = new User();
        user.setId(1);
        user.setUserName("zong");
        user.setNote("note");
        String s1 = aes.encryptHex(JSON.toJSONString(user));
        System.out.println(s1);
    }

    @Test
    public void decrypt() {
        String s = "e15c9fa8d1eb0ee5f56e824ffbe252ec206ff606b91058c4a6bd6d7de71892666ab9329a8fda5a75f480cf5b8ab8fef6";
        String result = aes.decryptStr(s);
        System.out.println(result);
        System.out.println(JSON.parseObject(result, User.class));
    }

}
