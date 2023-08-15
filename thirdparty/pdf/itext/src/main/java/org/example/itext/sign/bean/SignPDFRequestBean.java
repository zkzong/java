package com.example.itext.sign.bean;

import java.util.List;

public class SignPDFRequestBean {
    private String srcPDFPath; // 待签章pdf文件路径
    private String outPDFPath;    // 签章后输出的pdf文件路径
    private List<SignPDFBean> SignPDFBeans;

    public String getSrcPDFPath() {
        return srcPDFPath;
    }

    public void setSrcPDFPath(String srcPDFPath) {
        this.srcPDFPath = srcPDFPath;
    }

    public String getOutPDFPath() {
        return outPDFPath;
    }

    public void setOutPDFPath(String outPDFPath) {
        this.outPDFPath = outPDFPath;
    }

    public List<SignPDFBean> getSignPDFBeans() {
        return SignPDFBeans;
    }

    public void setSignPDFBeans(List<SignPDFBean> signPDFBeans) {
        SignPDFBeans = signPDFBeans;
    }

    @Override
    public String toString() {
        return "SignPDFRequestBean [srcPDFPath=" + srcPDFPath + ", outPDFPath="
                + outPDFPath + ", SignPDFBeans=" + SignPDFBeans + "]";
    }
}
