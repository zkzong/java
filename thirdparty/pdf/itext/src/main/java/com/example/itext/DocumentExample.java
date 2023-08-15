package com.example.itext;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.List;

public class DocumentExample {

    @Test
    public void modify() {
        try {
            //Create PdfReader instance.
            PdfReader pdfReader = new PdfReader("../pdf/chunk.pdf");

            //Create PdfStamper instance.
            PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("../pdf/output-chunk.pdf"));

            //Create BaseFont instance.
            BaseFont baseFont = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

            //Get the number of pages in pdf.
            int pages = pdfReader.getNumberOfPages();

            AcroFields acroFields = pdfStamper.getAcroFields();
            List<AcroFields.FieldPosition> multiLinePosition = acroFields.getFieldPositions("name");
            int page = multiLinePosition.get(0).page;
            Rectangle rectangle = multiLinePosition.get(0).position;
            float left = rectangle.getLeft();
            float right = rectangle.getRight();
            float top = rectangle.getTop();
            float bottom = rectangle.getBottom();

            //Iterate the pdf through pages.
            for (int i = 1; i <= pages; i++) {
                //Contain the pdf data.
                PdfContentByte pageContentByte = pdfStamper.getOverContent(i);

                pageContentByte.beginText();
                //Set text font and size.
                pageContentByte.setFontAndSize(baseFont, 14);
                Rectangle rectangle1 = new Rectangle(100, 100, 100, 100);
                //rectangle1.sett
                Chunk chunk = new Chunk();
                //chunk.setTextRenderMode()
                pageContentByte.rectangle(left, right, bottom, top);

                //pageContentByte.setTextMatrix(left, right, bottom, top, left, top);

                //Write text
                pageContentByte.showText("javawithease.comfdsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                pageContentByte.endText();
            }

            //Close the pdfStamper.
            pdfStamper.close();

            System.out.println("PDF modified successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
