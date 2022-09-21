package org.example.itext;

import com.itextpdf.text.DocumentException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
    public void simple() throws Exception {
        pdfOpt.simple("../pdf/simple.pdf", "../pdf/simple-output.pdf");
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

    @Test
    public void getPosition() {
        try {
            pdfOpt.getPosition("../pdf/simple.pdf", "");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}