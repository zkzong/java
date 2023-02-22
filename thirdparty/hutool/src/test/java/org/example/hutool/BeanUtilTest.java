package org.example.hutool;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import org.example.common.entity.Less;
import org.example.common.entity.More;
import org.junit.Test;

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

}
