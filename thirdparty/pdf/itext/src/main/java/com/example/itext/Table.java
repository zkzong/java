package com.example.itext;

import com.example.itext.util.PathUtil;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Table {
    private static final String DEST = "table.pdf";
    private static final String HTML = "html/table.html";
    private static final String FONT = "simhei.ttf";

    private static Configuration freemarkerCfg = null;

    static {
        freemarkerCfg = new Configuration();
        // freemarker的模板目录
        try {
            freemarkerCfg.setDirectoryForTemplateLoading(new File(PathUtil.getCurrentPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException, DocumentException {
        Map<String, Object> data = new HashMap();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10000; i++) {
            sb.append("<tr class=\"proto-tr\"><td>" + (i + 1) + "</td>")
                    .append("<td>GMLOC93848487483234</td>")
                    .append("<td>GMLOC93848487483234</td>")
                    .append("<td>测试数据</td>")
                    .append("<td>123456789123456789</td>")
                    .append("<td>12345678900</td>")
                    .append("<td>1000.00</td>")
                    .append("<td>1000.00</td>")
                    .append("<td>500.00</td>")
                    .append("<td>12</td>")
                    .append("<td>2019年11月11日</td>")
                    .append("<td>2019年11月11日</td>")
                    .append("<td>1000.00</td>")
                    .append("<td>1000.00</td>")
                    .append("<td>1000.00</td>")
                    .append("<td>1000.00</td>")
                    .append("<td>1000.00</td>")
                    .append("<td></td></tr>");
        }

        data.put("content", sb.toString());
        String content = Table.freeMarkerRender(data, HTML);
        Table.createPdf(content, DEST);
    }


    public static void createPdf(String content, String dest) throws IOException, DocumentException {
        /**
         * 使用该方式，表格 列内容过长，不自动换行
         */
        //// step 1
        //Document document = new Document(PageSize.A4);
        //// step 2
        //PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        //// step 3
        //document.open();
        //// step 4
        //XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
        //fontImp.register(FONT);
        //XMLWorkerHelper.getInstance().parseXHtml(writer, document,
        //        new ByteArrayInputStream(content.getBytes()), null, Charset.forName("UTF-8"), fontImp);
        //// step 5
        //document.close();

        //OutputStream outputStream = new FileOutputStream(new File("test.html"));
        //outputStream.write(content.getBytes());
        //outputStream.close();

        /**
         * 自动换行，需要引入core-renderer包
         */
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(content);

        ITextFontResolver fontResolver = renderer.getFontResolver();
        //if("linux".equals(getCurrentOperatingSystem())){
        //    fontResolver.addFont("/usr/share/fonts/chiness/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        //}else{
        //    fontResolver.addFont("c:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        //}
        //BaseFont baseFont = BaseFont.createFont("simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        try {
            fontResolver.addFont("simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            OutputStream pdf = new FileOutputStream(new File(dest));

            renderer.layout();
            renderer.createPDF(pdf);
            pdf.close();
        } catch (com.lowagie.text.DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * freemarker渲染html
     */
    public static String freeMarkerRender(Map<String, Object> data, String htmlTmp) {
        Writer out = new StringWriter();
        try {
            // 获取模板,并设置编码方式
            Template template = freemarkerCfg.getTemplate(htmlTmp);
            template.setEncoding("UTF-8");
            // 合并数据模型与模板
            template.process(data, out); //将合并后的数据和模板写入到流中，这里使用的字符流
            out.flush();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
