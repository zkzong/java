package com.example.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.Sets;
import com.google.common.collect.TreeRangeMap;
import com.google.common.math.LongMath;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.math.RoundingMode;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Zong on 2016/10/11.
 */
public class CollectTest {

    // ==============================Set==============================
    @Test
    public void set() {
        Set<String> set = Sets.newHashSet("a", "b", "c");
        System.out.println(set);

        // difference union intersection
        Set set1 = new LinkedHashSet();
        Map<String, Object> m1 = new HashMap<>();
        m1.put("id", 1);
        m1.put("name", "zong");
        set1.add(m1);
        Map<String, Object> m2 = new HashMap<>();
        m2.put("id", 2);
        m2.put("name", "wang");
        set1.add(m2);
        Map<String, Object> m3 = new HashMap<>();
        m3.put("id", 3);
        m3.put("name", "liu");
        set1.add(m3);
        Map<String, Object> m4 = new HashMap<>();
        m4.put("id", 4);
        m4.put("name", "ma");
        set1.add(m4);
        Map<String, Object> m5 = new HashMap<>();
        m5.put("id", 5);
        m5.put("name", "zhang");
        set1.add(m5);
        System.out.println("set1: " + set1);

        Set set2 = new LinkedHashSet();
        Map<String, Object> m6 = new HashMap<>();
        m6.put("id", 4);
        m6.put("name", "ma");
        set2.add(m6);
        Map<String, Object> m7 = new HashMap<>();
        m7.put("id", 5);
        m7.put("name", "zhang");
        set2.add(m7);
        Map<String, Object> m8 = new HashMap<>();
        m8.put("id", 8);
        m8.put("name", "ma");
        set2.add(m8);
        System.out.println("set2: " + set2);

        System.out.println("Sets.difference(set1, set): " + Sets.difference(set1, set2));
        System.out.println("Sets.union(set1, set): " + Sets.union(set1, set2));
        System.out.println("Sets.intersection(set1, set): " + Sets.intersection(set1, set2));
    }

    @Test
    public void multiset() {
        Multiset<String> multiset = HashMultiset.create();

        multiset.add("a");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");

        System.out.println(multiset.size()); // 5
        System.out.println(multiset.count("a")); // 2
    }

    // ==============================List==============================
    @Test
    public void list() {
        List list = Lists.newArrayList();
        System.out.println(list.size());
        list = Lists.newArrayListWithCapacity(1);
        System.out.println(list.size());
        list = Lists.newArrayListWithExpectedSize(10);
        System.out.println(list.size());
    }

    // ==============================Map==============================
    @Test
    public void map() {
        Map<String, String> map = Maps.newHashMap();
        map.put("a", "a");
        System.out.println(map);
    }

    // BiMap - 双向Map
    @Test
    public void biMap() {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("Hydra", "Programmer");
        biMap.put("Tony", "IronMan");
        biMap.put("Thanos", "Titan");
        //使用key获取value
        System.out.println(biMap.get("Tony"));

        BiMap<String, String> inverse = biMap.inverse();
        //使用value获取key
        System.out.println(inverse.get("Titan"));

        // 反转后操作的影响
        HashBiMap<String, String> biMap1 = HashBiMap.create();
        biMap1.put("Hydra", "Programmer");
        biMap1.put("Tony", "IronMan");
        biMap1.put("Thanos", "Titan");
        BiMap<String, String> inverse1 = biMap1.inverse();
        System.out.println(inverse1);

        inverse1.put("IronMan", "Stark");
        System.out.println(biMap1);

        // value不可重复
        HashBiMap<String, String> biMap2 = HashBiMap.create();
        biMap2.put("Tony", "IronMan");
        biMap2.put("Stark", "IronMan");
        //biMap.forcePut("Stark", "IronMan");
        System.out.println(biMap2);
    }

    @Test
    public void multiMap() {
        Multimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.put("day", 1);
        multimap.put("day", 2);
        multimap.put("day", 8);
        multimap.put("month", 3);
        System.out.println(multimap);

        // 获取值的集合
        Collection<Integer> day = multimap.get("day");
        System.out.println(day);

        ArrayListMultimap<String, Integer> multimap1 = ArrayListMultimap.create();
        List<Integer> day1 = multimap1.get("day");
        System.out.println(day1);

        // 操作get后的集合
        ArrayListMultimap<String, Integer> multimap2 = ArrayListMultimap.create();
        multimap2.put("day", 1);
        multimap2.put("day", 2);
        multimap2.put("day", 8);
        multimap2.put("month", 3);

        List<Integer> day2 = multimap2.get("day");
        List<Integer> month = multimap2.get("month");

        day2.remove(0);//这个0是下标
        month.add(12);
        System.out.println(multimap2);

        // 转换为Map
        Map<String, Collection<Integer>> map = multimap.asMap();
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        map.get("day").add(20);
        System.out.println(multimap);

        // 数量问题
        System.out.println(multimap.size());
        System.out.println(multimap.entries().size());
        for (Map.Entry<String, Integer> entry : multimap.entries()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
        System.out.println(multimap.keySet().size());
        Set<Map.Entry<String, Collection<Integer>>> entries = multimap.asMap().entrySet();
        System.out.println(entries.size());

    }

    @Test
    public void rangeMap() {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closedOpen(0, 60), "fail");
        rangeMap.put(Range.closed(60, 90), "satisfactory");
        rangeMap.put(Range.openClosed(90, 100), "excellent");

        System.out.println(rangeMap.get(59));
        System.out.println(rangeMap.get(60));
        System.out.println(rangeMap.get(90));
        System.out.println(rangeMap.get(91));

        rangeMap.remove(Range.closed(70, 80));
        System.out.println(rangeMap.get(75));

    }

    @Test
    public void classToInstanceMap() {
        ClassToInstanceMap<Object> instanceMap = MutableClassToInstanceMap.create();
        User user = new User("Hydra", 18);
        Dept dept = new Dept("develop", 200);

        instanceMap.putInstance(User.class, user);
        instanceMap.putInstance(Dept.class, dept);

        User user1 = instanceMap.getInstance(User.class);
        System.out.println(user == user1);

        ClassToInstanceMap<Map> instanceMap1 = MutableClassToInstanceMap.create();
        HashMap<String, Object> hashMap = new HashMap<>();
        TreeMap<String, Object> treeMap = new TreeMap<>();

        instanceMap1.putInstance(HashMap.class, hashMap);
        instanceMap1.putInstance(TreeMap.class, treeMap);

    }

    @Data
    @AllArgsConstructor
    class User {

        private String name;
        private Integer age;

    }

    @Data
    @AllArgsConstructor
    class Dept {

        private String name;
        private Integer code;
    }

    @Test
    public void range() {
        // 400w * 10 分库
        long lower = 4000000 * 10L;
        long upper = 4000000 * 10 * 2L;
        long volume = 4000000 * 10L;
        int partitionSize = Math.toIntExact(LongMath.divide(upper - lower, volume, RoundingMode.CEILING));
        Map<Integer, Range<Long>> result = Maps.newHashMapWithExpectedSize(partitionSize + 2);
        result.put(0, Range.lessThan(lower));

        for (int i = 0; i < partitionSize; ++i) {
            result.put(i + 1, Range.closedOpen(lower + (long) i * volume, Math.min(lower + (long) (i + 1) * volume, upper)));
        }
        result.put(partitionSize + 1, Range.atLeast(upper));
        System.out.println(result);
    }
}
