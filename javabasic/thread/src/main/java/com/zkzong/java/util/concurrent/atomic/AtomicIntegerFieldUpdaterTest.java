package com.zkzong.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {

    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    // 原子更新字段类都是抽象类，每次使用都时候必须使用静态方法newUpdater创建一个更新器。
    // 原子更新类的字段的必须使用public volatile修饰符。
    public static void main(String[] args) {
        User user = new User("ma", 20);
        System.out.println(a.getAndIncrement(user));// 20
        System.out.println(a.get(user)); // 21
    }

    public static class User {
        private String name;
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }
}
