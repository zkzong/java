package com.example.apache.commons.lang;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;
import java.util.UUID;

/**
 * 生产指定长度随机字符串a-z,A-Z,0-9
 * Created by Zong on 2017/1/15.
 */
public class RandomString {
    /**
     * 获取随机字符串 a-z,A-Z,0-9
     *
     * @param length 长度
     * @return
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(62);// [0,62)
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获得0-9,a-z,A-Z范围的随机数
     *
     * @param length 长度
     * @return
     */
    public static String getRandomChar(int length) {
        char[] chr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            buffer.append(chr[random.nextInt(62)]);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(getRandomString(32));
        System.out.println(getRandomChar(32));

        // UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);

        System.out.println(RandomStringUtils.randomAlphabetic(32));
        System.out.println(RandomStringUtils.randomAlphanumeric(32));
    }
}
