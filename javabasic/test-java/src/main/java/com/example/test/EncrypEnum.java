package com.example.test;

/**
 * Created by zzk on 17/1/4.
 */
public enum EncrypEnum {
    AES(1, "AES"),
    RSA(2, "RSA");

    EncrypEnum(Integer encrypCode, String encrypType) {
        this.encrypCode = encrypCode;
        this.encrypType = encrypType;
    }

    private Integer encrypCode;
    private String encrypType;

    public Integer getEncrypCode() {
        return encrypCode;
    }

    public String getEncrypType() {
        return encrypType;
    }

    public static void main(String[] args) {
        System.out.println(EncrypEnum.AES);
        for (EncrypEnum ee : EncrypEnum.values()) {
            System.out.println(ee + " === Code:" + ee.getEncrypCode() + ", Type:" + ee.getEncrypType());
        }
    }
}
