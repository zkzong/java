package com.example.qrcode;

public class QRCodeUtilTest {
    //测试
    public static void main(String[] args) throws Exception {
        String text = "http://www.baidu.com";
        //生成带LOGO的二维码
        //QRCodeUtil.encode(text, "D:\\Program Files\\码农新锐.jpg", "D:\\Program Files\\upload", true);
        //生成不带LOGO的二维码
        QRCodeUtil.encode(text, "D:\\Program Files\\upload", true);
    }
}