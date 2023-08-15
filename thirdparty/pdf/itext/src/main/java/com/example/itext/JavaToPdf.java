package com.example.itext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author zkzong
 * @date 2017/12/6
 */
public class JavaToPdf {
    PdfWriter writer;
    Document document;

    @Before
    public void before() throws FileNotFoundException, DocumentException {
        document = new Document();
        writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
    }

    @After
    public void after() {
        document.close();
        writer.close();
    }

    // 生成一个PDF
    @Test
    public void pdf1() throws DocumentException {
        document.open();
        document.add(new Paragraph("hello world"));
    }

    // 页面大小,页面背景色,页边空白,Title,Author,Subject,Keywords
    @Test
    public void pdf2() throws DocumentException, FileNotFoundException {
        Rectangle rect = new Rectangle(PageSize.B5.rotate());
        // 页面背景色
        rect.setBackgroundColor(BaseColor.ORANGE);

        Document doc = new Document(rect);

        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("HelloWorld.pdf"));

        // PDF版本(默认1.4)
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);

        // 文档属性
        doc.addTitle("Title@sample");
        doc.addAuthor("Author@rensanning");
        doc.addSubject("Subject@iText sample");
        doc.addKeywords("Keywords@iText");
        doc.addCreator("Creator@iText");

        // 页边空白
        doc.setMargins(10, 20, 30, 40);

        doc.open();
        doc.add(new Paragraph("Hello World"));
    }

    // 设置密码
    @Test
    public void pdf3() throws FileNotFoundException, DocumentException {
        Document doc = new Document();
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("HelloWorld.pdf"));

        // 设置密码为："World"
        writer.setEncryption("Hello".getBytes(), "World".getBytes(),
                PdfWriter.ALLOW_SCREENREADERS,
                PdfWriter.STANDARD_ENCRYPTION_128);

        doc.open();
        doc.add(new Paragraph("Hello World"));
        doc.close();
        writer.close();
    }

    @Test
    public void pdf4() throws DocumentException {
        document.open();
        document.add(new Paragraph("First page"));

        document.newPage();
        writer.setPageEmpty(false);

        document.newPage();
        document.add(new Paragraph("New page"));
    }
}
