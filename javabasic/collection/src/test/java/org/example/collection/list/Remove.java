package com.example.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Zong on 2016/11/17.
 */
public class Remove {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = new String("abc");
        String str4 = new String("abc");

        List<String> list = new ArrayList<>();
        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str4);

        // 不能全部删除符合条件的数据
        // 原因：List每remove掉一个元素以后，后面的元素都会向前移动，此时如果执行i=i+1，则刚刚移过来的元素没有被读取
        System.out.println("list.size() = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if ("abc".equals(s)) {
                list.remove(i);
            }
        }
        System.out.println("after remove : list.size() = " + list.size());

        // 使用foreach删除报错：Exception in thread "main" java.util.ConcurrentModificationException
        for (String s : list) {
            list.remove(s);
        }

        // 三种解决办法
        // 1. 倒序遍历
        System.out.println("list.size() = " + list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            String s = list.get(i);
            if ("abc".equals(s)) {
                list.remove(i);
            }
        }
        System.out.println("after remove : list.size() = " + list.size());
        // 2. 每移除一个元素以后把i移回来
        System.out.println("list.size() = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if ("abc".equals(s)) {
                list.remove(i);
                i--;
            }
        }
        System.out.println("after remove : list.size() = " + list.size());
        // 3. 使用iterator.remove()方法移除
        System.out.println("list.size() = " + list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if ("abc".equals(s)) {
                it.remove();
            }
        }
        System.out.println("after remove : list.size() = " + list.size());
    }

    /**
     * 使用foreach删除倒数第二个元素不会报错
     */
    @Test
    public void remove() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        for (String item : list) {
            System.out.println(item);
            if (item.equals("4")) {
                list.remove(item);
            }
        }
    }
}
