package com.zkzong.designpattern.gof_quanke_name.simplefactory.chart;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Zong on 2016/11/23.
 * 工具类XMLUtil
 */
public class XMLUtil {
    /**
     * 该方法用于从XML配置文件中提取图表类型，并返回类型名
     *
     * @return
     */
    public static String getChartType() {
        try {
            // 创建DOM文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("designpattern/src/main/java/com/zkzong/designpattern/gof_quanke_name/simplefactory/chart/config.xml"));

            // 获取包含图表类型的文本节点
            NodeList nl = doc.getElementsByTagName("chartType");
            Node classNode = nl.item(0).getFirstChild();
            String chartType = classNode.getNodeValue();

            return chartType;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
