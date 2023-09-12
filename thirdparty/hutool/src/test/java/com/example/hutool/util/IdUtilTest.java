package com.example.hutool.util;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;

public class IdUtilTest {

    @Test
    public void uuid() {
        // 生成的UUID是带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
        String uuid = IdUtil.randomUUID();
        System.out.println(uuid);

        // 生成的是不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
        String simpleUUID = IdUtil.simpleUUID();
        System.out.println(simpleUUID);
    }

    @Test
    public void objectid() {
        // 生成类似：5b9e306a4df4f8c54a39fb0c
        String id = ObjectId.next();
        System.out.println(id);

        // 方法2：从Hutool-4.1.14开始提供
        String id2 = IdUtil.objectId();
        System.out.println(id2);
    }

    /**
     * 注意 IdUtil.createSnowflake每次调用会创建一个新的Snowflake对象，不同的Snowflake对象创建的ID可能会有重复，因此请自行维护此对象为单例，或者使用IdUtil.getSnowflake使用全局单例对象。
     */
    @Test
    public void Snowflake() {
        // 参数1为终端ID
        // 参数2为数据中心ID
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        long id = snowflake.nextId();
        System.out.println(id);

        // 简单使用
        id = IdUtil.getSnowflakeNextId();
        System.out.println(id);
        String idStr = IdUtil.getSnowflakeNextIdStr();
        System.out.println(idStr);
    }

}
