package org.example.lombok;

import org.junit.Test;

/**
 * Created by Zong on 2017/6/26.
 */
public class UserTest {
    @Test
    public void set() {
        User u = new User();
        u.setName("zong");
        u.setAge(30);
        System.out.println(u);
    }
}
