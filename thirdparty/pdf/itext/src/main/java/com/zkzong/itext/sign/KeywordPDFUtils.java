package com.zkzong.itext.sign;

import com.google.common.collect.Lists;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.zkzong.itext.sign.bean.KeyWordBean;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeywordPDFUtils {
    // 定义返回页码
    private static int i = 0;
    private static com.itextpdf.awt.geom.Rectangle2D.Float boundingRectange = null;

    private static List<KeyWordBean> lists = null;

    // private static KeyWordBean bean = new KeyWordBean();

    private static Map<Integer, List<KeyWordBean>> map = new HashMap<Integer, List<KeyWordBean>>();

    public static Map<Integer, List<KeyWordBean>> getPDFText(String filePath) {
        try {
            PdfReader pdfReader = new PdfReader(filePath);
            int pageNum = pdfReader.getNumberOfPages();
            PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(pdfReader);

            for (i = 1; i <= pageNum; i++) {
                lists = Lists.newArrayList();
                boundingRectange = new com.itextpdf.awt.geom.Rectangle2D.Float();
                pdfReaderContentParser.processContent(i, new RenderListener() {
                    @Override
                    public void renderText(TextRenderInfo textRenderInfo) {
                        String text = textRenderInfo.getText(); // 整页内容
                        boundingRectange = textRenderInfo.getBaseline().getBoundingRectange();
                        KeyWordBean bean = new KeyWordBean();
                        bean.setX(boundingRectange.x);
                        bean.setY(boundingRectange.y);
                        bean.setPage(i);
                        bean.setText(text);
                        lists.add(bean);
                    }

                    @Override
                    public void renderImage(ImageRenderInfo arg0) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void endTextBlock() {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void beginTextBlock() {
                        // TODO Auto-generated method stub

                    }
                });
                map.put(i, lists);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        Map<Integer, List<KeyWordBean>> keyWords = getPDFText("D:\\pdf\\src.pdf");
        System.out.println(keyWords.size());
    }

    public static KeyWordBean getKeyWordXY(Map<Integer, List<KeyWordBean>> map2, int page, int num, String keyWord) {
        int keyMatch = 1;
        StringBuilder content = new StringBuilder();
        List<KeyWordBean> list = map.get(page);
        Collections.sort(list);//正序比较
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            KeyWordBean bean = list.get(i);
            String text = bean.getText();
            if (i + 1 != list.size()) {
                KeyWordBean beanNext = list.get(i + 1);
                float x = beanNext.getX() - bean.getX();
                float y = beanNext.getY() - bean.getY();
                if (y == 0 && x <= 1) {
                    // System.out.print(“去除因字体加粗产生的重复数字”);
                } else {
                    if (StringUtils.contains(content.toString(), keyWord) || StringUtils.contains(text, keyWord)) {
                        if (keyMatch == num) {
                            return bean;
                        } else {
                            keyMatch++;
                        }
                    } else if ((!StringUtils.isEmpty(text) && keyWord.startsWith(text)) || content.length() > 0) {
                        content.append(text);
                        if (content.length() >= keyWord.length()) {
                            if (StringUtils.contains(content.toString(), keyWord)) {
                                if (keyMatch == num) {
                                    return bean;
                                } else {
                                    keyMatch++;
                                }
                            }
                            content = new StringBuilder();
                        }
                    }
                }
            } else {
                if (StringUtils.contains(content.toString(), keyWord) || StringUtils.contains(text, keyWord)) {
                    if (keyMatch == num) {
                        return bean;
                    } else {
                        keyMatch++;
                    }
                } else if ((!StringUtils.isEmpty(text) && keyWord.startsWith(text)) || content.length() > 0) {
                    content.append(text);
                    if (content.length() >= keyWord.length()) {
                        if (StringUtils.contains(content.toString(), keyWord)) {
                            if (keyMatch == num) {
                                return bean;
                            } else {
                                keyMatch++;
                            }
                        }
                        content = new StringBuilder();
                    }
                }
            }
        }
        return null;
    }

    public static KeyWordBean getKeyWordBean(KeyWordBean bean, StringBuilder content, String keyWord, String text, int keyMatch, int num) {
        if (StringUtils.contains(content.toString(), keyWord) || StringUtils.contains(text, keyWord)) {
            if (keyMatch == num) {
                return bean;
            } else {
                keyMatch++;
            }
        } else if ((!StringUtils.isEmpty(text) && keyWord.startsWith(text)) || content.length() > 0) {
            content.append(text);
            if (content.length() >= keyWord.length()) {
                if (StringUtils.contains(content.toString(), keyWord)) {
                    if (keyMatch == num) {
                        return bean;
                    } else {
                        keyMatch++;
                    }
                }
                content = new StringBuilder();
            }
        }
        return null;

    }
}
