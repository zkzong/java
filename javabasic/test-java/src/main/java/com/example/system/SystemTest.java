package com.example.system;

import org.junit.Test;

import java.util.Properties;
import java.util.Set;

/**
 * Created by Zong on 2017/5/9.
 */
public class SystemTest {
    public static void main(String[] args) {
        // 1、文件相关
        // 行分隔符
        System.out.println(System.getProperty("file.separator"));
        // 路径分隔符
        System.out.println(System.getProperty("path.separator"));
        // 行分隔符
        System.out.println(System.getProperty("line.separator"));
        // 系统编码
        System.out.println(System.getProperty("file.encoding"));

    }

    /**
     * 看所有当前 JVM 的系统属性
     */
    @Test
    public void jvm() {
        // 获取所有系统属性
        Properties properties = System.getProperties();

        // 按顺序打印所有属性
        properties.list(System.out);

        // 或者，更优雅地打印（按键名排序）
        System.out.println("\n=== 排序后的系统属性 ===");
        Set<String> keys = properties.stringPropertyNames();
        keys.stream().sorted().forEach(key -> {
            String value = properties.getProperty(key);
            System.out.println(key + " = " + value);
        });

        // 获取单个属性
        String userHome = System.getProperty("user.home");
        System.out.println("\n你的家目录是: " + userHome);
    }
}
