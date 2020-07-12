package com.zkzong.sb.security2.sysmanager.entity;

/**
 * Created by Zong on 2017/6/2.
 */
public enum AclResourceTypeEnum {
    MODULE("M"),
    SUBMODULE("S"),
    REQUEST("R");

    String value;

    AclResourceTypeEnum() {
    }

    AclResourceTypeEnum(String value) {
        this.value = value;
    }
}
