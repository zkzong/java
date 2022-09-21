package org.example.itext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zkzong
 * @date 2017/12/6
 */
public class JavaToPdfCN {
    private static final String DEST = "HelloWorld_CN.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        // 方法一：使用Windows系统字体(TrueType)
//        BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        // 方法二：使用iTextAsian.jar中的字体
//        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

        // 方法三：使用资源字体(ClassPath)
        BaseFont baseFont = BaseFont.createFont("simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont);
        document.add(new Paragraph("hello world，我是宗", font));
        document.close();
        writer.close();
    }
}
