package com.example.image;

import org.junit.Test;

/**
 * @Author: Zong
 * @Date: 2018/12/7
 */
public class Image2StringUseIOTest {

    @Test
    public void getImageBinary() {
        String str = Image2StringUseIO.getImageBinary();
        // 将图片转成base64编码
        System.out.println(str);
    }

    @Test
    public void base64StringToImage() {
        String str = Image2StringUseIO.getImageBinary();
        // 将图片转成base64编码
        System.out.println(str);
        // 将base64的编码转成图片
        Image2StringUseIO.base64StringToImage(str);
    }

    @Test
    public void getImageBase64String() {
        String imageStr = Image2StringUseIO.getImageBase64String("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png", "png");
        System.out.println(imageStr);
    }
}