package com.example.hutool.util;

import cn.hutool.core.util.ObjectUtil;
import com.example.hutool.util.entity.Person;
import org.junit.Test;

public class ObjectUtilTest {

    @Test
    public void test() {
        // 此方法不能判断对象中字段为空的情况，如果需要检查Bean对象中字段是否全空，请使用BeanUtil.isEmpty。
        Person person = new Person();
        // false
        System.out.println(ObjectUtil.isEmpty(person));
        // false
        System.out.println(ObjectUtil.isNull(person));

        person = null;
        // true
        System.out.println(ObjectUtil.isEmpty(person));
        // true
        System.out.println(ObjectUtil.isNull(person));
    }
}
