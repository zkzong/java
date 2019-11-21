package com.zkzong.itext.sign;

import com.zkzong.itext.sign.bean.KeyWordBean;
import com.zkzong.itext.sign.bean.SignPDFBean;
import com.zkzong.itext.sign.bean.SignPDFRequestBean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception {
        /*
         * 签章参数
         */
        // String keyWord = "85000315"; // 签章关键字
        // int page = 1; // 关键字所在页数
        // int num = 1; // 取第n次出现的关键字
        // String srcPDFPath = "D:\pdf\test2.pdf"; // 待签章pdf文件路径
        // String outPDFPath = "D:\pdf\out.pdf"; // 签章后输出的pdf文件路径
        // String sealPath = "D:\pdf\印章.png"; // 印章图片路径
        // String keyStorePath = "D:\pdf\keystore"; // 证书文件路径
        // String keyStorePass = "Jitadmin001"; // 证书密码
        // String signReason = "设置签章原因"; // 设置签章原因，可以为空
        // String signLocation = "设置签章地点 "; // 设置签章地点
        List list = new ArrayList();
        SignPDFBean bean1 = new SignPDFBean();
        bean1.setKeyStorePass("123456");
        bean1.setKeyStorePath("src/main/resources/sign.keystore");
        // bean1.setKeyStorePass("Jitadmin001");
        // bean1.setKeyStorePath("D:\pdf\keystore");
        bean1.setKeyWord("85000315");
        bean1.setNum(1);
        bean1.setPage(1);
        bean1.setSealPath("D:/pdf/印章.png");
        bean1.setSignLocation("知春路1");
        bean1.setSignReason("测试1");
        SignPDFBean bean2 = new SignPDFBean();
        bean2.setKeyStorePass("123456");
        bean2.setKeyStorePath("src/main/resources/sign.keystore");
        bean2.setKeyWord("客户");
        bean2.setNum(1);
        bean2.setPage(1);
        bean2.setSealPath("D:\\pdf\\印章2.png");
        bean2.setSignLocation("知春路2");
        bean2.setSignReason("测试2");

        SignPDFBean bean3 = new SignPDFBean();
        bean3.setKeyStorePass("123456");
        bean3.setKeyStorePath("src/main/resources/sign.keystore");
        bean3.setKeyWord("五");
        bean3.setNum(1);
        bean3.setPage(1);
        bean3.setSealPath("D:\\pdf\\印章3.png");
        bean3.setSignLocation("知春路3");
        bean3.setSignReason("测试3");

        list.add(bean1);
        list.add(bean2);
        list.add(bean3);

        SignPDFRequestBean requestBean = new SignPDFRequestBean();
        requestBean.setSrcPDFPath("D:\\pdf\\test2.pdf");
        requestBean.setOutPDFPath("D:\\pdf\\out.pdf");
        requestBean.setSignPDFBeans(list);

        long startTime = System.currentTimeMillis();
        // 1.解析pdf文件
        Map<Integer, List<KeyWordBean>> map = KeywordPDFUtils.getPDFText(requestBean.getSrcPDFPath());
        // 2.获取关键字坐标
        List<SignPDFBean> beans = requestBean.getSignPDFBeans();
        byte[] fileData = null;
        InputStream in = null;
        for (int i = 0; i < beans.size(); i++) {
            SignPDFBean pdfBean = beans.get(i);
            KeyWordBean bean = KeywordPDFUtils.getKeyWordXY(map, pdfBean.getPage(), pdfBean.getNum(), pdfBean.getKeyWord());
            if (null == bean) {
                System.out.println("未查询到关键字。。。");
            }
            System.out.println(bean.toString());
            long keyTime = System.currentTimeMillis();
            if (i == 0) {
                in = new FileInputStream(requestBean.getSrcPDFPath());
            } else {
                in = new ByteArrayInputStream(fileData);
            }
            // 3.进行盖章
            fileData = SignPDFUtils.sign(pdfBean.getKeyStorePass(), pdfBean.getKeyStorePath(), in, pdfBean.getSealPath(), bean.getX(), bean.getY(), bean.getPage(), pdfBean.getSignReason(), pdfBean.getSignLocation());
            long signTime = System.currentTimeMillis();
        }
        // 4.输出盖章后pdf文件
        FileOutputStream f = new FileOutputStream(new File(requestBean.getOutPDFPath()));
        f.write(fileData);
        f.close();
        in.close();
        long endTime = System.currentTimeMillis();
        // System.out.println("关键字定位花费时间："+(keyTime-startTime));
        // System.out.println("盖章消耗时间："+(signTime-keyTime));
        System.out.println("总时间：" + (endTime - startTime));
    }
}
