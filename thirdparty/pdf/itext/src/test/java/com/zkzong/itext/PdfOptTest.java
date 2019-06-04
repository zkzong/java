package com.zkzong.itext;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author: Zong
 * @Date: 2018/12/9
 */
public class PdfOptTest {

    PdfOpt pdfOpt;

    @Before
    public void setUp() {
        pdfOpt = new PdfOpt();
    }

    @Test
    public void fillTemplateSimple() throws Exception {
        pdfOpt.fillTemplateSimple("../pdf/template.pdf", "../pdf/output1.pdf");
    }

    @Test
    public void fillTemplate() throws Exception {
        pdfOpt.fillTemplate("../pdf/template.pdf", "../pdf/output2.pdf");
    }

    @Test
    public void multiLineAndBold() throws Exception {
        pdfOpt.multiLineAndBold("../pdf/chunk-template.pdf", "../pdf/output3.pdf");
    }
}