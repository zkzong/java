package com.example.apache.commons.lang;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * Created by zong on 2016/8/15.
 */
public class StringUtilsTest {

    @Test
    public void test() {
        // 截取从****开始字符串
        System.out.println(StringUtils.substringAfter("select * from person", "from"));

        // 判断该字符串是否为数字组长，如果是返回true；但该方法不识别有小数点的字符串
        System.out.println(StringUtils.isNumeric("12345.22"));

        // 在右边加字符，使之总长度为6
        System.out.println(StringUtils.rightPad("abc", 6, "T"));

        // 首字母大写
        System.out.println(StringUtils.capitalize("abc"));

        // 删除空格
        System.out.println(StringUtils.deleteWhitespace("  ab c "));

        // 左边两个字符
        System.out.println(StringUtils.left("abcd", 2)); // ab
    }

    @Test
    public void join() {
        String[] arr = {"a", "b", "c"};
        System.out.println(StringUtils.join(arr, ","));
    }

    @Test
    public void isEmpty() {
        // isEmpty isNotEmpty
        // 判断某字符串是否为空，为空的标准是 str==null 或 str.length()==0
        System.out.println(StringUtils.isEmpty(null)); // true
        System.out.println(StringUtils.isEmpty("")); // true
        System.out.println(StringUtils.isEmpty(" ")); // false
        System.out.println(StringUtils.isEmpty("  ")); // false
    }

    @Test
    public void isBlank() {
        // isBlank isNotBlank
        // 判断某字符串是否为空或长度为0或由空白符(whitespace) 构成
        System.out.println(StringUtils.isBlank(null)); // true
        System.out.println(StringUtils.isBlank("")); // true
        System.out.println(StringUtils.isBlank(" ")); // true
        System.out.println(StringUtils.isBlank("  ")); // true
        System.out.println(StringUtils.isBlank("\t\n\f\r")); // true //对于制表符、换行符、换页符和回车符
        System.out.println(StringUtils.isBlank("\b")); // false "\b"为单词边界符
    }

    // trimToNull
    // trimToEmpty

    @Test
    public void repeat() {
        String str = "mo";
        // 重复字符串
        String repeat = StringUtils.repeat(str, 3);
        System.out.println(repeat);
    }

    @Test
    public void countMatches() {
        // 计算一个字符串某个字符的出现次数
        String str = "abcabcddsccb";
        int count = StringUtils.countMatches(str, "b");
        System.out.println(count);
    }
}
