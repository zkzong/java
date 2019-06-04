package com.zkzong.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author zkzong
 * @date 2017/11/11
 */
public class TestHelloWorld {
    @Test()
    public void testEmailGenerator() {
        RandomEmailGenerator obj = new RandomEmailGenerator();
        String email = obj.generate();

        Assert.assertNotNull(email);
        Assert.assertEquals(email, "feedback@yoursite.com");
    }
}
