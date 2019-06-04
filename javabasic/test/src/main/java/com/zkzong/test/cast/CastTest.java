package com.zkzong.test.cast;

import org.junit.Test;

/**
 * Created by Zong on 2017/4/11.
 */
public class CastTest {

    Father father = new Father();
    Son son = new Son();
    Father fs = new Son();

    @Test
    public void f2s() {
        father = son;
        son = (Son) fs;
        son = (Son) father; // 报错
    }
}
