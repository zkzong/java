package com.zkzong.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Zong on 2017/5/4.
 */
public class List2Set {
    public static void main(String[] args) {
        User u1 = new User("zong", 20);
        User u2 = new User("zong", 20);
        User u3 = new User("zong", 21);
        User u4 = new User("ma", 20);
        List<User> list = new ArrayList<User>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        System.out.println(list.size());

        Set<User> set = new HashSet<User>();
        set.addAll(list);
        System.out.println(set.size());

    }
}
