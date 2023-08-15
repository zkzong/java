package com.example.apache.commons.lang;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.junit.Test;

/**
 * Created by Zong on 2017/1/17.
 */
public class LangTest {

    @Test
    public void test() {
        // 取得类名
        System.out.println(ClassUtils.getShortClassName(LangTest.class)); // LangTest

        // 取得包名
        System.out.println(ClassUtils.getPackageName(LangTest.class)); // com.example.apache.commons.lang

        // 字符串转数字
        System.out.println(NumberUtils.toInt("6")); // 6

        System.out.println(StringEscapeUtils.escapeHtml("<html>")); // &lt;html&gt;

        System.out.println(StringEscapeUtils.escapeJava("String")); // String

    }
}
