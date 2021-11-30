package com.zkzong.hutool.str;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * @Author: zong
 * @Date: 2021/11/26
 */
public class StrUtilTest {

    @Test
    public void a() {
        String s = "/a/b/c/d/e";
        int i = StrUtil.indexOf(s, '/', 3);
        System.out.println(i);
    }


    @Test
    public void b() {
        String s = "= service.add(user);";
        int i = StrUtil.ordinalIndexOf(s, "service", 1);
        System.out.println(i);
        int j = StrUtil.indexOf(s, '(', i);
        System.out.println(j);

        String sub = StrUtil.sub(s, i, j);
        System.out.println(sub);

    }
}
