package com.zkzong.pdf;

import org.junit.Test;

import java.io.File;

public class Pdf2StringTest {

    /*BASE64Encoder和BASE64Decoder这两个方法是sun公司的内部方法，并没有在java api中公开过，所以使用这些方法是不安全的，
     * 将来随时可能会从中去除，所以相应的应该使用替代的对象及方法，建议使用apache公司的API*/
//    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
//    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    @Test
    public void getPDFBinary() {
        //将PDF格式文件转成base64编码
        String base64String = Pdf2String.getPDFBinary(new File("pdf/git-cheat-sheet.pdf"));
        System.out.println(base64String);
    }

    @Test
    public void base64StringToPDF() {
        //将PDF格式文件转成base64编码
        String base64String = Pdf2String.getPDFBinary(new File("pdf/git-cheat-sheet.pdf"));
        System.out.println(base64String);
        //将base64的编码转成PDF格式文件
        Pdf2String.base64StringToPDF(base64String);
    }
}