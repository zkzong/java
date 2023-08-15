package com.example.pdf;

import org.junit.Test;

public class Pdf2ImageTest {

    @Test
    public void pdf2Image() {
        Pdf2Image.pdf2Image("../pdf/jys2.pdf", "../pdf", 105);
    }

    @Test
    public void pdfToImage() {
        Pdf2Image.pdfToImage("../pdf/jys2.pdf");
    }
}