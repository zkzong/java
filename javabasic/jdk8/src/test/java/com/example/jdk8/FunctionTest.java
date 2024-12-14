package com.example.jdk8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: zongz
 * @Date: 2024-12-14
 */
public class FunctionTest {

    /***
     * 简化转换逻辑：整数转换为其字符串
     */
    @Test
    public void apply() {
        Function<Integer, String> intToString = Object::toString;
        System.out.println(intToString.apply(123)); // 输出: "123"
    }

    /***
     * 多步转换：先将整数转换为字符串，再计算字符串的长度
     */
    @Test
    public void andThen() {
        Function<Integer, String> intToString = Object::toString;
        Function<String, Integer> stringLength = String::length;

        Function<Integer, Integer> lengthOfIntString = intToString.andThen(stringLength);
        System.out.println(lengthOfIntString.apply(12345)); // 输出: 5
    }

    /***
     * 数据转换
     */
    @Test
    public void map() {
        List<String> names = Arrays.asList("john", "jane", "alice");
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperNames); // 输出: [JOHN, JANE, ALICE]
    }
}
