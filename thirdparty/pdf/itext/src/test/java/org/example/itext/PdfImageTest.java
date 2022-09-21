package org.example.itext;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.List;

public class PdfImageTest {

    @Test
    public void insertImage() {
        try {
            String TemplatePDF = "../pdf/image-template.pdf"; // 模板路径
            String outFile = "../pdf/output1.pdf"; // 生成新的pdf的路径
            PdfReader reader = new PdfReader(TemplatePDF);
            PdfStamper ps = new PdfStamper(reader, new FileOutputStream(outFile)); // 生成的输出流

            AcroFields s = ps.getAcroFields();
            // 插入文字
            //insertText(ps, s);
            // 插入图片
            PdfImage.insertImage(ps, s);
            ps.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建Chunk
     *
     * @return
     */
    public static Chunk CreateChunk() {
        BaseFont bfChinese;
        Chunk chunk = null;
        try {
            bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
            Font fontChinese = new Font(bfChinese, 10 * 4 / 3);
            chunk = new Chunk("张三", fontChinese);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chunk;
    }

    /**
     * 插入文本
     */
    public static void insertText(PdfStamper ps, AcroFields s) {
        List<AcroFields.FieldPosition> list = s.getFieldPositions("CONNECT_NAME");
        Rectangle rect = list.get(0).position;

        PdfContentByte cb = ps.getOverContent(1);
        PdfPTable table = new PdfPTable(1);
        float tatalWidth = rect.getRight() - rect.getLeft() - 1;
        table.setTotalWidth(tatalWidth);

        PdfPCell cell = new PdfPCell(new Phrase(CreateChunk()));
        cell.setFixedHeight(rect.getTop() - rect.getBottom() - 1);
        cell.setBorderWidth(0);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setLeading(0, (float) 1.1);

        table.addCell(cell);
        table.writeSelectedRows(0, -1, rect.getLeft(), rect.getTop(), cb);
    }

}