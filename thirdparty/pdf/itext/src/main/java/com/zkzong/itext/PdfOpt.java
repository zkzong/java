package com.zkzong.itext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PdfOpt {

    public void simple(String templateFile, String outputFile) throws IOException, DocumentException {
        // 模版文件目录
        PdfReader reader = new PdfReader(templateFile);
        // 生成的输出流
        PdfStamper ps = new PdfStamper(reader, new FileOutputStream(outputFile));
        //ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //PdfStamper ps = new PdfStamper(reader, bos);

        AcroFields acroFields = ps.getAcroFields();

        // new Float(0)：自适应大小，且setFieldProperty必须在setField之前才起作用
        acroFields.setFieldProperty("name", "textsize", new Float(0), null);

        acroFields.setField("name", "在路上法兰蝶阀据了解发了来到福建");

        ps.setFormFlattening(true);

        ps.close();
        reader.close();
    }

    public void fillTemplateSimple(String templateFile, String outputFile) throws Exception {
        FileOutputStream fos = null;

        try {
            PdfReader reader = new PdfReader(templateFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PdfStamper ps = new PdfStamper(reader, bos);
            /**
             * 使用中文字体 如果是利用 AcroFields填充值的不需要在程序中设置字体，在模板文件中设置字体为中文字体就行了
             */
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font font = new Font(bf, 12, Font.BOLD);
            //Font font = FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD, BaseColor.RED);
            AcroFields s = ps.getAcroFields();
            System.out.println("AcroFields: " + s.getFields());
            System.out.println("BlankSignatureNames: " + s.getBlankSignatureNames());

            // 设置加粗只能用这种方式
            List<AcroFields.FieldPosition> multiLinePosition = s.getFieldPositions("name");
            int page = multiLinePosition.get(0).page;
            Rectangle rectangle = multiLinePosition.get(0).position;
            float left = rectangle.getLeft();
            float right = rectangle.getRight();
            float top = rectangle.getTop();
            float bottom = rectangle.getBottom();
            PdfContentByte pdfContentByte = ps.getOverContent(page);
            ColumnText columnText = new ColumnText(pdfContentByte);

            Rectangle r = new Rectangle(left, bottom, right, top);
            columnText.setSimpleColumn(r);

            //FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD, BaseColor.RED)
            Chunk chunk = new Chunk("在路上");
            Paragraph paragraph = new Paragraph(12, chunk);
            //paragraph.setSpacingBefore(16);
            columnText.addText(paragraph);
            // 设置字体，如果不设置添加的中文将无法显示
            paragraph.setFont(font);
            columnText.addElement(paragraph);
            columnText.go();

            //s.setField("name", "在路上");
            //s.setFieldProperty("name", "textfont", font, null);
            s.setField("age", "30");

            ps.setFormFlattening(true);
            ps.close();
            fos = new FileOutputStream(outputFile);
            fos.write(bos.toByteArray());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // doc.close();
            fos.close();
        }
    }

    /**
     * 功能：
     * 获取文本域
     * 获取签名域
     * 设置字体、大小、颜色、居中方式
     * 多行设置行间距、加粗
     * 填充后部分字段仍可编辑
     *
     * @param templateFile
     * @param outputFile
     * @throws IOException
     * @throws DocumentException
     */
    public void fillTemplate(String templateFile, String outputFile) throws IOException, DocumentException {
        // 模版文件目录
        PdfReader reader = new PdfReader(templateFile);
        // 生成的输出流
        PdfStamper ps = new PdfStamper(reader, new FileOutputStream(outputFile));
        //ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //PdfStamper ps = new PdfStamper(reader, bos);

        AcroFields acroFields = ps.getAcroFields();

        // pdf表单相关信息展示，getFields方法获取所有域
        Map<String, AcroFields.Item> fieldMap = acroFields.getFields();
        System.out.println("============文本域============");
        for (Map.Entry<String, AcroFields.Item> entry : fieldMap.entrySet()) {
            // name就是pdf模版中各个文本域的名字
            String name = entry.getKey();
            AcroFields.Item item = entry.getValue();
            PdfDictionary merged = item.getMerged(0);
            if (PdfName.TX.equals(merged.getAsName(PdfName.FT))) {
                System.out.println("[name]:" + name + ", [value]: " + item);
            }
        }
        System.out.println("============数字签名域============");
        ArrayList<String> blankSignatureNames = acroFields.getBlankSignatureNames();
        for (String blankSignatureName : blankSignatureNames) {
            System.out.println(blankSignatureName);
        }

        String nameField = "name";
        String ageField = "age";

        // 设置字体
        BaseFont baseFont = BaseFont.createFont("sszhjt.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        acroFields.setFieldProperty(nameField, "textfont", baseFont, null);
        // 设置字体大小
        // 不能用int，setFieldProperty方法重载了，使用int会执行另一个方法，不能设置大小
        acroFields.setFieldProperty(nameField, "textsize", new Float(3), null);
        // 设置颜色
        acroFields.setFieldProperty(nameField, "textcolor", BaseColor.RED, null);
        // 居中方式：靠右对齐
        AcroFields.Item name = acroFields.getFieldItem(nameField);
        name.getMerged(0).put(PdfName.Q, new PdfNumber(PdfFormField.Q_RIGHT));
        acroFields.setField(nameField, "在路上");
        acroFields.setField(ageField, "30");
        // 居中
        AcroFields.Item singleLineItem = acroFields.getFieldItem("singleLine");
        singleLineItem.getMerged(0).put(PdfName.Q, new PdfNumber(PdfFormField.Q_CENTER));
        acroFields.setField("singleLine", "雪梅·其一");
        // 行间距
        AcroFields.Item multiLineItem = acroFields.getFieldItem("multiLine");
        //multiLineItem.getMerged(0).put(PdfName, new PdfNumber(PdfFormField.FF_MULTILINE));
        //acroFields.setField("multiLine", "梅雪争春未肯降，骚人搁笔费评章。梅须逊雪三分白，雪却输梅一段香。");
        List<AcroFields.FieldPosition> multiLinePosition = acroFields.getFieldPositions("multiLine");
        int page = multiLinePosition.get(0).page;
        Rectangle rectangle = multiLinePosition.get(0).position;
        float left = rectangle.getLeft();
        float right = rectangle.getRight();
        float top = rectangle.getTop();
        float bottom = rectangle.getBottom();

        //BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
        Font font = new Font(baseFont, 12, Font.BOLD, BaseColor.BLACK);
        PdfContentByte pdfContentByte = ps.getOverContent(page);
        ColumnText columnText = new ColumnText(pdfContentByte);

        Rectangle r = new Rectangle(left, bottom, right, top);
        columnText.setSimpleColumn(r);

        //FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD, BaseColor.RED)
        Chunk chunk = new Chunk("梅雪争春未肯降，骚人搁笔费评章。梅须逊雪三分白，雪却输梅一段香。");
        Paragraph paragraph = new Paragraph(12, chunk);
        paragraph.setSpacingBefore(16);
        columnText.addText(paragraph);
        // 设置字体，如果不设置添加的中文将无法显示
        paragraph.setFont(font);
        columnText.addElement(paragraph);
        columnText.go();

        // 数字签名不能使用这种方式填充
        acroFields.setField("signName", "黑土");
        acroFields.setField("signAge", "2");

        // 中文字体
//        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//        acroFields.setFieldProperty(nameField, "textfont", bfChinese, null);
        // 数字
//        acroFields.setFieldProperty(nameField, "textfont", );

        // 这种方式只是把field的属性设置为只读，仍然可以使用acrobat修改
        //acroFields.setFieldProperty(nameField, "setfflags", TextField.READ_ONLY, null);
        //acroFields.setFieldProperty(ageField, "setfflags", TextField.READ_ONLY, null);

        // partialFormFlattening和setFormFlattening(true)配合使用，保证partialFormFlattening的field不可编辑，其他的field可以编辑
        //ps.partialFormFlattening("name");
        //ps.partialFormFlattening("age");
        //ps.partialFormFlattening("singleLine");
        //ps.partialFormFlattening("multiLine");
        // 不可编辑
        ps.setFormFlattening(true);

        ps.close();
        reader.close();
    }

    /**
     * 文本域多行设置行间距并加粗
     *
     * @param templateFile
     * @param outputFile
     * @throws IOException
     * @throws DocumentException
     */
    public void multiLineAndBold(String templateFile, String outputFile) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(templateFile);
        PdfStamper ps = new PdfStamper(reader, new FileOutputStream(outputFile));

        AcroFields acroFields = ps.getAcroFields();

        acroFields.setField("title", "咏梅");
        List<AcroFields.FieldPosition> multiLinePosition = acroFields.getFieldPositions("content");
        int page = multiLinePosition.get(0).page;
        Rectangle rectangle = multiLinePosition.get(0).position;
        float left = rectangle.getLeft();
        float right = rectangle.getRight();
        float top = rectangle.getTop();
        float bottom = rectangle.getBottom();

        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
        Font font = new Font(baseFont, 12, Font.BOLD, BaseColor.BLACK);

        ps.setFormFlattening(true);

        PdfContentByte pdfContentByte = ps.getOverContent(page);
        ColumnText columnText = new ColumnText(pdfContentByte);

        Rectangle r = new Rectangle(left, bottom, right, top);
        columnText.setSimpleColumn(r);

        //FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD, BaseColor.RED)
        Chunk chunk = new Chunk("梅雪争春未肯降，骚人搁笔费评章。梅须逊雪三分白，雪却输梅一段香。");
        Paragraph paragraph = new Paragraph(12, chunk);
        paragraph.setSpacingBefore(16);
        columnText.addText(paragraph);
        // 设置字体，如果不设置添加的中文将无法显示
        paragraph.setFont(font);
        columnText.addElement(paragraph);
        columnText.go();

        ps.close();
        reader.close();
    }

}
