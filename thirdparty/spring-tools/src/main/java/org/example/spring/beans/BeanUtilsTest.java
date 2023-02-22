package org.example.spring.beans;

import org.example.common.entity.Less;
import org.example.common.entity.More;
import org.example.common.entity.Person;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Zong on 2017/5/22.
 */
public class BeanUtilsTest {

    // 字段类型不一样不能赋值
    @Test
    public void test() {
        More more = new More(1, "zong", 1);
        more.setSex("1");
        System.out.println(more);
        Less less = new Less();
        BeanUtils.copyProperties(more, less);
        System.out.println(less);
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
        BeanUtils.copyProperties(sList, tList);
        System.out.println(tList.size());

        // 需要遍历copyProperties
        for (int i = 0; i < sList.size(); i++) {
            Person p = new Person();
            BeanUtils.copyProperties(sList.get(i), p);
            tList.add(p);
        }
        System.out.println(tList.size());

    }

    @Test
    public void nullProperty() {
        Person p1 = new Person();
        p1.setName("");
        p1.setAge(10);

        Person p2 = new Person();
        p2.setName("ma");
        p2.setAge(30);

        System.out.println("===改变前===");
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);

        BeanUtils.copyProperties(p1, p2, getNullPropertyNames(p1));

        System.out.println("===改变后===");
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
    }


    public String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null || "".equals(srcValue)) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
