package com.zkzong.mockito;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Zong on 2017/4/7.
 * http://blog.csdn.net/sdyy321/article/details/38757135/
 */
public class MockitoTest {

    // 验证行为
    @Test
    public void verifyBehaviour() {
        // 模拟创建一个List对象
        List list = mock(List.class);

        // 使用mock的对象
        list.add(1);
        list.clear();

        // 验证add(1)和clear()行为是否发生
        verify(list).add(1);
        verify(list).clear();
    }

    @Test
    public void whenThenReturn() {
        // mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        // 预设当iterator调用next()时第一次返回hello，第n次都返回world
        when(iterator.next()).thenReturn("hello").thenReturn("world");
        // 使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        // 验证结果
        assertEquals("hello world world", result);
    }
}
