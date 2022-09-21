package org.example.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.Sets;
import com.google.common.math.LongMath;
import org.junit.Test;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Zong on 2016/10/11.
 */
public class CollectTest {

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
    public void list() {
        List list = Lists.newArrayList();
        System.out.println(list.size());
        list = Lists.newArrayListWithCapacity(1);
        System.out.println(list.size());
        list = Lists.newArrayListWithExpectedSize(10);
        System.out.println(list.size());
    }

    @Test
    public void map() {
        Map<String, String> map = Maps.newHashMap();
        map.put("a", "a");
        System.out.println(map);
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
