package com.example.jdk8.stream;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Arrays.sort;

public class StreamTest {

    private List<User> users = new ArrayList<>();

    @Before
    public void before() {
        User u1 = new User();
        u1.setName("张");
        u1.setAge(10);
        u1.setSalary(new BigDecimal("100.10"));
        users.add(u1);

        User u2 = new User();
        u2.setName("王");
        u2.setAge(10);
        u2.setSalary(new BigDecimal("200.20"));
        users.add(u2);

        User u3 = new User();
        u3.setName("张");
        u3.setAge(30);
        u3.setSalary(new BigDecimal("300.30"));
        users.add(u3);
    }

    @Test
    public void groupingBy() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("id", "1");
        map1.put("idNo", "1234");
        list.add(map1);
        Map<String, String> map2 = new HashMap<>();
        map2.put("id", "2");
        map2.put("idNo", "1234");
        list.add(map2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("id", "1");
        map3.put("idNo", "2345");
        list.add(map3);
        Map<String, String> map4 = new HashMap<>();
        map4.put("id", "2");
        map4.put("idNo", "2345");
        list.add(map4);
        System.out.println("原始数据：" + list);

        // 根据idNo分组
        Map<String, List<Map<String, String>>> maps = list.stream().collect(Collectors.groupingBy((Map<String, String> m) -> m.get("idNo")));
        System.out.println("分组后：" + maps);
        Set<Map.Entry<String, List<Map<String, String>>>> entries = maps.entrySet();
        for (Map.Entry<String, List<Map<String, String>>> entry : entries) {
            String key = entry.getKey();
            List<Map<String, String>> value = entry.getValue();
            System.out.println("分组后entry：" + entry);
            System.out.println("分组后key：" + key);
            System.out.println("分组后value：" + value);
        }
    }

    @Test
    public void sum() {
        // 对某个字段求和
        int ageSum = users.stream().mapToInt(x -> x.getAge()).sum();
        System.out.println(ageSum);
        BigDecimal salarySum = users.stream().map(User::getSalary).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(salarySum);
    }

    // 分组求和
    @Test
    public void groupsum() {
        final Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getName));
        System.out.println(collect);

        Map<String, BigDecimal> map = new HashMap<>();

        collect.forEach((name, userList) -> {
            //System.out.println(name);
            //System.out.println(userList);
            BigDecimal sum = new BigDecimal(0);
            for (User user : userList) {
                BigDecimal salary = user.getSalary();
                sum = sum.add(salary);
                map.put(name, sum);
            }
        });
        System.out.println(map);

        final Map<String, IntSummaryStatistics> m = users.stream().collect(Collectors.groupingBy(User::getName, Collectors.summarizingInt(User::getAge)));
        System.out.println(m);
    }

    @Test
    public void min() {
        // 获取年龄最小的人，有可能是多个
        // 1. 按年龄分组
        Map<Integer, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(collect);
        // 获取年龄最小的List
        Set<Integer> ageSet = collect.keySet();
        Object[] objects = ageSet.toArray();
        sort(objects);
        List<User> users = collect.get(objects[0]);

        Random random = new Random();
        int n = random.nextInt(users.size());
        User user = users.get(n);
        System.out.println(user);

        // todo 更简单的操作
        Comparator<User> comparing = Comparator.comparing(User::getAge);
        Collector<User, ?, Optional<User>> userOptionalCollector = Collectors.minBy(comparing);
    }

    @Test
    public void filter() {
        long count = users.stream().filter(o -> o.getAge() == 10).count();
        System.out.println(count);

        Optional<User> user = users.stream().filter(o -> o.getName().equals("王")).findFirst();
        if (user.isPresent()) {
            User u = user.get();
            System.out.println(u.getAge());
        }

        BigDecimal sum = users.stream().filter(o -> o.getName().equals("张"))
                .map(User::getSalary).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);
    }

    @Test
    public void map() {
        System.out.println(users);
        // 一个字段
        List<String> list = users.stream().map(e -> e.getName()).collect(Collectors.toList());
        System.out.println(list);
        // 多个字段
        List<User> userList = users.stream().map(e -> new User(e.getName(), e.getAge())).collect(Collectors.toList());
        System.out.println(userList);

        // 当key重复时，该方法默认会抛出IllegalStateException: Duplicate key异常
        // 可以设置为重复key时，覆盖
        Map<BigDecimal, Integer> collect1 = users.stream().collect(Collectors.toMap(User::getSalary, User::getAge));
        System.out.println(collect1);
        // (key1, key2) -> key1 前面覆盖后面
        // (key1, key2) -> key2 后面覆盖前面
        Map<String, Integer> collect2 = users.stream().collect(Collectors.toMap(User::getName, User::getAge, (key1, key2) -> key1));
        System.out.println(collect2);
    }
}
