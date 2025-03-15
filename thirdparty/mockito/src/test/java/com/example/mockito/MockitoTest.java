package com.example.mockito;

import org.junit.Test;
import org.mockito.InOrder;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
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

    @Test
    public void verifyTest() {
        Person mockPerson = mock(Person.class);
        mockPerson.setId(1);
        mockPerson.setName("TestOps");

        // 验证
        verify(mockPerson).setId(1);
        verify(mockPerson).setName("TestOps");
    }

    @Test
    public void stubTest() {
        Person mockPerson = mock(Person.class);
        when(mockPerson.getId()).thenReturn(1);
        when(mockPerson.getName()).thenThrow(new NoSuchMethodError());

        System.out.println(mockPerson.getId());
        //System.out.println(mockPerson.getName());
    }

    @Test
    public void matchTest() {
        Person mockPerson = mock(Person.class);
        when(mockPerson.setKeyById(anyInt())).thenReturn("001TestOps100");
        System.out.println(mockPerson.setKeyById(10));
        verify(mockPerson).setKeyById(anyInt());
    }

    @Test
    public void timesTest() {
        Person mockPerson = mock(Person.class);
        mockPerson.setId(1);
        mockPerson.setName("TestOps");
        mockPerson.setName("TestOps");

        verify(mockPerson).setId(1);
        verify(mockPerson, times(2)).setName("TestOps");
    }

    @Test
    public void orderTest() {
        Person singleMock = mock(Person.class);
        singleMock.setName("TestOps");
        singleMock.setName("Mango");

        InOrder inOrder = inOrder(singleMock);
        inOrder.verify(singleMock).setName("TestOps");
        inOrder.verify(singleMock).setName("Mango");

        Person firstMock = mock(Person.class);
        Person secondMock = mock(Person.class);
        firstMock.setId(1);
        secondMock.setId(2);

        InOrder inOrder1 = inOrder(firstMock, secondMock);
        inOrder1.verify(firstMock).setId(1);
        inOrder1.verify(secondMock).setId(2);
    }

    @Test
    public void consStubTest() {
        Person personMock = mock(Person.class);
        when(personMock.getName())
                .thenReturn("TestOps")
                .thenReturn("1")
                .thenThrow(new NoSuchMethodError());
        System.out.println(personMock.getName());
        System.out.println(personMock.getName());
        //System.out.println(personMock.getName());
    }

    @Test
    public void spyTest() {
        Person person = new Person(1, "TestOps");
        Person spy = spy(person);
        when(spy.getName()).thenReturn("Mango");
        System.out.println(spy.getName());
        System.out.println(spy.getId());
    }
}
