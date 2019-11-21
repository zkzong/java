package com.zkzong.itext.sign.bean;

public class SignPDFBean {
    private String keyWord; // 签章关键字
    private int page; // 关键字所在页数
    private int num; // 取第n次出现的关键字
    private String sealPath; // 印章图片路径
    private String keyStorePath; // 证书文件路径
    private String keyStorePass; // 证书密码
    private String signReason; // 设置签章原因，可以为空
    private String signLocation; // 设置签章地点

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSealPath() {
        return sealPath;
    }

    public void setSealPath(String sealPath) {
        this.sealPath = sealPath;
    }

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    public String getKeyStorePass() {
        return keyStorePass;
    }

    public void setKeyStorePass(String keyStorePass) {
        this.keyStorePass = keyStorePass;
    }

    public String getSignReason() {
        return signReason;
    }

    public void setSignReason(String signReason) {
        this.signReason = signReason;
    }

    public String getSignLocation() {
        return signLocation;
    }

    public void setSignLocation(String signLocation) {
        this.signLocation = signLocation;
    }

    @Override
    public String toString() {
        return "SignPDFBean[keyWord =" + keyWord + ",page =" + page + ",num ="
                + num + ",sealPath =" + sealPath + ",keyStorePath ="
                + keyStorePath + ",keyStorePass =" + keyStorePass
                + ",signReason =" + signReason + ",signLocation ="
                + signLocation + "]";
    }
}
