package com.example.hutool.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.example.common.entity.Less;
import com.example.common.entity.More;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

}
