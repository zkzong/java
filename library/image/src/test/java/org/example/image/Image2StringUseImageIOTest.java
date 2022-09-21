package org.example.image;

import org.junit.Test;

/**
 * @Author: Zong
 * @Date: 2018/12/7
 */
public class Image2StringUseImageIOTest {

    @Test
    public void getImageBinary() {
        String str = Image2StringUseImageIO.getImageBinary();
        // 将图片转成base64编码
        System.out.println(str);
    }

    @Test
    public void base64StringToImage() {
        String str = Image2StringUseImageIO.getImageBinary();
        // 将图片转成base64编码
        System.out.println(str);
        // 将base64的编码转成图片
        Image2StringUseImageIO.base64StringToImage(str);
    }

    @Test
    public void getImageBase64StringUrl() {
        String imageStr1 = Image2StringUseImageIO.getImageBase64StringUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png", "png");
        System.out.println(imageStr1);
    }

    @Test
    public void getImageBase64StringHttpGet() {
        String imageStr2 = Image2StringUseImageIO.getImageBase64StringHttpGet("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png", "png");
        System.out.println(imageStr2);
    }

    @Test
    public void getImgeHexString() {
        String s = Image2StringUseImageIO.getImgeHexString("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png", "png");
        System.out.println(s);
    }

    @Test
    public void saveImage() {
        String str = Image2StringUseImageIO.getImageBinary();
        Image2StringUseImageIO.saveImage(str, "pdf/test.png", "png");
    }
}