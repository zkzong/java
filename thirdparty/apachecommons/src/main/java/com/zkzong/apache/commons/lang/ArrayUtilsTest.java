package com.zkzong.apache.commons.lang;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

/**
 * Created by Zong on 2017/1/17.
 */
public class ArrayUtilsTest {
    @Test
    public void array() {
        String[] s1 = new String[]{"1", "2", "3"};
        String[] s2 = new String[]{"a", "b", "c"};
        // 合并数组
        String[] s = (String[]) ArrayUtils.addAll(s1, s2);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        // 数组转字符串，逗号分隔
        String str = ArrayUtils.toString(s);
        str = str.substring(1, str.length() - 1);
        System.out.println(str + ">>" + str.length());

        String[] strArr = {"abc", "def", "gh"};
        boolean isExist = ArrayUtils.contains(strArr, "a");
        System.out.println(isExist);

    }
}
