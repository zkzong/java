package com.example.hutool.util;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * @Author: zong
 * @Date: 2021/11/26
 */
public class StrUtilTest {

    @Test
    public void indexOf() {
        String s = "/aaaaa/b/c/d/e";
        // 从 坐标 3 开始查找/出现的位置
        int i = StrUtil.indexOf(s, '/', 3);
        System.out.println(i);

        String ss = "= service.add(user);";
        // 查找 service 第1次出现的位置
         i = StrUtil.ordinalIndexOf(ss, "service", 1);
        System.out.println(i);
        // 从指定起始位置开始查找
        int j = StrUtil.indexOf(ss, '(', i);
        System.out.println(j);

        String sub = StrUtil.sub(ss, i, j);
        System.out.println(sub);
    }

    @Test
    public void lastIndexOfIgnoreCase() {
        String s = "a.b.c.d.e";
        // 查找 . 最后1次出现位置
        int i = StrUtil.lastIndexOfIgnoreCase(s, ".");
        System.out.println(i);

        String s1 = s.substring(0, i);
        System.out.println(s1);
        String s2 = s.substring(i + 1, s.length());
        System.out.println(s2);

    }


}
