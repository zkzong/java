package org.example.collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Zong on 2016/7/22.
 * http://www.importnew.com/20703.html
 */
public class MapSortValue {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("d", "d");
        map.put("b", "b");
        map.put("a", "a");
        map.put("c", "c");

        // 对value排序我们就需要借助于Collections的sort(List<T> list, Comparator<? super T> c)方法，该方法根据指定比较器产生的顺序对指定列表进行排序。
        // 但是有一个前提条件，那就是所有的元素都必须能够根据所提供的比较器来进行比较。
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + " : " + mapping.getValue());
        }
    }
}
