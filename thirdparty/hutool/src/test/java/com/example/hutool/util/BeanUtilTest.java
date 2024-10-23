package com.example.hutool.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.example.common.entity.Less;
import com.example.common.entity.More;
import com.example.hutool.util.entity.Man;
import com.example.hutool.util.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtilTest {

    // 字段类型不一样可以赋值
    @Test
    public void more2Less() {
        More more = new More(1, "zong", 1);
        more.setSex("1");
        System.out.println(more);
        Less less = new Less();
        BeanUtil.copyProperties(more, less);
        System.out.println(less);
    }

    // null覆盖有值字段
    // 如果需要不覆盖，加入CopyOptions.create().setIgnoreNullValue(true)参数
    @Test
    public void nullcopy() {
        More more = new More(1, "zong", 1);
        more.setSex("1");
        System.out.println(more);
        Less less = new Less();
        // 空值（非null）会覆盖有值字段
        //less.setName("");
        BeanUtil.copyProperties(less, more, CopyOptions.create().setIgnoreNullValue(true));
        System.out.println(more);
    }

    /**
     * 集合之间copy
     */
    @Test
    public void copyList() {
        List<More> moreList = new ArrayList<>();
        More more1 = new More(1, "1", 1);
        moreList.add(more1);
        More more2 = new More(2, "2", 2);
        moreList.add(more2);
        More more3 = new More(3, "3", 3);
        moreList.add(more3);
        System.out.println(moreList);

        List<Less> lessList = BeanUtil.copyToList(moreList, Less.class);
        System.out.println(lessList);
    }

    @Test
    public void isEmpty() {
        // 字段没有原生类型时，会返回true
        Person person = new Person();
        // true
        System.out.println(BeanUtil.isEmpty(person));

        // 字段有原生类型时，会返回false
        Man man = new Man();
        // false
        System.out.println(BeanUtil.isEmpty(man));
    }

    @Test
    public void beanToMap() {
        Man man = new Man();
        man.setUserName("zong");
        man.setAge(10);
        Map<String, Object> map = BeanUtil.beanToMap(man, new HashMap<>(), false, false);
        System.out.println(map);
    }

    @Test
    public void copyToList() {
        List<More> moreList = new ArrayList<>();
        More more = new More(1, "zong", 1);
        more.setSex("1");
        moreList.add(more);
        List<Less> lesses = BeanUtil.copyToList(moreList, Less.class);
        System.out.println(lesses);
    }

}
