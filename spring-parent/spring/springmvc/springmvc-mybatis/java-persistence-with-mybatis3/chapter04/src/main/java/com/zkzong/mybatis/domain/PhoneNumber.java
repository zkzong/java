package com.zkzong.mybatis.domain;

import java.io.Serializable;

/**
 * Created by Zong on 2017/3/10.
 */
public class PhoneNumber implements Serializable {
    private String countryCode;
    private String stateCode;
    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(String countryCode, String stateCode, String number) {
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.number = number;
    }

    public PhoneNumber(String str) {
        if (str != null) {
            String[] parts = str.split("-");
            if (parts.length > 0) {
                this.countryCode = parts[0];
            }
            if (parts.length > 1) {
                this.stateCode = parts[1];
            }
            if (parts.length > 2) {
                this.number = parts[2];
            }
        }
    }

    @Override
    public String toString() {
        return this.getAsString();
    }

    public String getAsString() {
        return countryCode + "-" + stateCode + "-" + number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
