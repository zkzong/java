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
        final int i = StrUtil.indexOf(s, '/', 3);
        System.out.println(i);
    }
}
