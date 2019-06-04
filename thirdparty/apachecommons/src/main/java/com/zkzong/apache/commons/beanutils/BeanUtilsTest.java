package com.zkzong.apache.commons.beanutils;

import com.zkzong.common.Less;
import com.zkzong.common.More;
import com.zkzong.common.Person;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zong on 2016/8/15.
 */
public class BeanUtilsTest {
    public static void main(String[] args) {
        Person p1 = new Person("zong", 30);
        Person p2 = new Person();
        try {
            BeanUtils.copyProperties(p2, p1);
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p1 == p2); // false
            System.out.println(p1.equals(p2)); // false
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 属性多的对象向属性少的对象赋值
     * 字段类型不一致也能赋值，如果转换不成功，取默认值
     *
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void more2Less() throws InvocationTargetException, IllegalAccessException {
        More more = new More(1, "zong", 1);
        more.setSex("1");
        System.out.println(more);
        Less less = new Less();
        BeanUtils.copyProperties(less, more);
        System.out.println(less);
    }

    /**
     * 属性少的对象向属性多的对象赋值
     * 字段类型不一致也能赋值，如果转换不成功，取默认值
     *
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void less2More() throws InvocationTargetException, IllegalAccessException {
        Less less = new Less(1, "ma");
        less.setSex(1);
        System.out.println(less);
        More more = new More();
        BeanUtils.copyProperties(more, less);
        System.out.println(more);
    }

    @Test
    public void list2list() throws InvocationTargetException, IllegalAccessException {
        Person p1 = new Person("zong", 30);
        Person p2 = new Person("ma", 25);
        Person p3 = new Person("liu", 20);
        List<Person> sList = new ArrayList<Person>(3);
        sList.add(p1);
        sList.add(p2);
        sList.add(p3);

        // list的泛型不能使用copyProperties
        List<Person> tList = new ArrayList<Person>(3);
        BeanUtils.copyProperties(tList, sList);
        System.out.println(tList.size());

        // 需要遍历copyProperties
        for (int i = 0; i < sList.size(); i++) {
            Person p = new Person();
            BeanUtils.copyProperties(p, sList.get(i));
            tList.add(p);
        }
        System.out.println(tList.size());

    }

}
