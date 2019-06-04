package com.zkzong.pdf;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Zong
 * @Date: 2018/12/7
 */
public class PdfToImageTest {

    @Test
    public void pdf2ImageOne() {
        PdfToImage.pdf2ImageOne("pdf/3.pdf");
    }

    @Test
    public void pdf2ImageMany() {
        PdfToImage.pdf2ImageMany("pdf/3.pdf", "pdf", 105);
    }
}