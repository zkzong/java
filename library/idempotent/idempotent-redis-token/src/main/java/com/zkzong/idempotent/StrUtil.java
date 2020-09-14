package com.zkzong.idempotent;

import org.apache.commons.lang.StringUtils;

public class StrUtil {

    public static String EMPTY = "";

    public static boolean isNotEmpty(String toString) {
        return StringUtils.isNotEmpty(toString);
    }

    public static boolean isBlank(String token) {
        return StringUtils.isBlank(token);
    }
}
