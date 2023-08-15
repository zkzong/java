package com.example.json.util;

import com.alibaba.fastjson.JSON;

/**
 * @Author: zong
 * @Date: 2019-06-21
 */
public class FastJsonUtil {
    public static String bean2Json(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        return JSON.parseObject(jsonStr, objClass);
    }
}
