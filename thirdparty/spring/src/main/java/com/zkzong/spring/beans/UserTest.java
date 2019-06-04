package com.zkzong.spring.beans;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * Created by Zong on 2017/5/22.
 */
public class UserTest {

    // 属性值少的复制给属性值多的，没有被复制到的属性就是该类型的默认值。 结果1......xy......null
    @Test
    public void lessToMore() {
        UserOne u1 = new UserOne();
        u1.setId(1);
        u1.setName("xy");
        UserTwo u2 = new UserTwo();
        BeanUtils.copyProperties(u1, u2);
        System.out.println(u2);
    }


    // 属性值多的复制给属性值少的。结果1......xy
    @Test
    public void moreToLess() {
        UserTwo u2 = new UserTwo();
        u2.setId(1);
        u2.setName("xy");
        u2.setAddress("aa");
        UserOne u1 = new UserOne();
        BeanUtils.copyProperties(u2, u1);
        System.out.println(u1);
    }


    //  u2的id类型是int,u3的id类型是String
    @Test
    public void argusMisMatch() {
        UserTwo u2 = new UserTwo();
        u2.setId(1);
        u2.setName("xy");
        u2.setAddress("aa");
        UserThree u3 = new UserThree();
        BeanUtils.copyProperties(u2, u3);
        System.out.println(u3);
    }
}
