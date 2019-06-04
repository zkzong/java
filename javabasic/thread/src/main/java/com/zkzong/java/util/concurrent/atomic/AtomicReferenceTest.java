package com.zkzong.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    private static AtomicReference<User> atomicReference = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("zong", 30);
        atomicReference.set(user);
        User updateUser = new User("ma", 20);
        atomicReference.compareAndSet(user, updateUser);
        System.out.println(atomicReference.get().getName()); // ma
        System.out.println(atomicReference.get().getOld()); // 20
    }

    static class User {
        private String name;
        private int old;

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
