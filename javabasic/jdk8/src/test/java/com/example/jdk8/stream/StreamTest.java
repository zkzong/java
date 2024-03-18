package com.example.jdk8.stream;

import lombok.Data;
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

    /**
     * 父子层级
     */
    @Test
    public void parentsub() {
        List<ParentSub> allList = intData();
        List<ParentSub> parentList = allList.stream().filter(p -> p.getParentId() == 0).collect(Collectors.toList());
        System.out.println("父类集合：" + parentList);
        // 两种方式实现
        // 1、双层循环
        for (ParentSub parentSub : parentList) {
            List<ParentSub> list = new ArrayList<>();
            for (ParentSub sub : allList) {
                if (sub.parentId == parentSub.getId()) {
                    list.add(sub);
                }
                parentSub.setSubList(list);
            }
        }
        System.out.println("父子类集合：" + parentList);
        // 2、stream
        List<ParentSub> pList = allList.stream().filter(p -> p.getParentId() == 0).collect(Collectors.toList());
        pList.stream().forEach(p -> {
            List<ParentSub> list = new ArrayList<>();
            for (ParentSub sub : allList) {
                if (p.getId().equals(sub.getParentId())) {
                    list.add(sub);
                }
            }
            p.setSubList(list);
        });
        System.out.println("父子类集合：" + pList);
    }

    @Test
    public void flatMap() {
        List<ParentSub> parentSubs = intData();
        List<ParentSub> collect = parentSubs.stream().filter(p -> p.getParentId() == 0).flatMap(p -> p.getSubList().stream()).collect(Collectors.toList());
        System.out.println("扁平化后：" + collect);
    }

    private List<ParentSub> intData() {

        ParentSub u1 = new ParentSub();
        u1.setId(1);
        u1.setName("a");
        u1.setAge(30);
        u1.setParentId(0);
        ParentSub u11 = new ParentSub();
        u11.setId(2);
        u11.setName("aa");
        u11.setAge(10);
        u11.setParentId(1);
        ParentSub u12 = new ParentSub();
        u12.setId(3);
        u12.setName("ab");
        u12.setAge(8);
        u12.setParentId(1);


        ParentSub u2 = new ParentSub();
        u2.setId(4);
        u2.setName("b");
        u2.setAge(40);
        u2.setParentId(0);
        ParentSub u21 = new ParentSub();
        u21.setId(5);
        u21.setName("bb");
        u21.setAge(18);
        u21.setParentId(4);

        return Arrays.asList(u1, u11, u12, u2, u21);

    }

    @Data
    class ParentSub {
        private Integer id;
        private Integer parentId;
        private String name;
        private Integer age;
        private List<ParentSub> subList;
    }

    @Test
    public void sum() {
        // 对某个字段求和
        int ageSum = users.stream().mapToInt(x -> x.getAge()).sum();
        System.out.println(ageSum);
        ageSum = users.stream().map(User::getAge).reduce(Integer.valueOf(0), Integer::sum);
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
