package com.zkzong.annotation.imooc.demo;

import java.lang.reflect.Field;

public class FilterTest {

    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserName("lucy");

        Filter f3 = new Filter();
        f3.setEmail("zong@163.com,han@163.com");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);
    }

    private static String query(Filter f) {
        StringBuilder sb = new StringBuilder();
        // 1. 获取到class
        Class c = f.getClass();
        // 2. 获取到table的名字
        boolean exists = c.isAnnotationPresent(Table.class);
        if (!exists) {
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");
        // 3. 遍历所有的字段
        Field[] fArray = c.getDeclaredFields();
        for (Field field : fArray) {
            // 4. 处理每个字段对应的sql
            // 4.1 拿到字段名
            boolean fExists = field.isAnnotationPresent(Column.class);
            if (!fExists) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            // 4.2 拿到字段的值
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            // 4.3 拼装sql

        }
        return null;
    }


}