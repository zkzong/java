package com.example.json;

import com.alibaba.fastjson.JSON;

/**
 * Created by Zong on 2016/8/6.
 */
public class GroupTest {
    public static void main(String[] args) {
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        //Encode
        String jsonString = JSON.toJSONString(group);
        System.out.println(jsonString);

        //Decode
        Group group1 = JSON.parseObject(jsonString, Group.class);
        System.out.println(group1);
    }
}
