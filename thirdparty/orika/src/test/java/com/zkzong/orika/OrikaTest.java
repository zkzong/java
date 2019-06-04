package com.zkzong.orika;

import com.zkzong.orika.dto.B;
import com.zkzong.orika.dto.BB;
import com.zkzong.orika.dto.BBB;
import com.zkzong.orika.pojo.A;
import com.zkzong.orika.pojo.AA;
import com.zkzong.orika.pojo.AAA;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @Author: zong
 * @Date: 2019.3.25
 */
public class OrikaTest {

    private MapperFacade mapperFacade;

    @Before
    public void before() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Test
    public void copyA2B() {
        A a = new A();
        a.setName("zong");
        B b = mapperFacade.map(a, B.class);
        System.out.println(b);
    }

    @Test
    public void copyAA2BB() {
        AA aa = new AA();
        aa.setName("zong");
        aa.setAge(20);
        BB bb = mapperFacade.map(aa, BB.class);
        System.out.println(bb);
    }

    @Test
    public void copyAAA2BBB() {
        AAA aaa = new AAA();
        aaa.setName("zong");
        aaa.setAge(20);
        aaa.setBirthDay(new Date());
        BBB bbb = mapperFacade.map(aaa, BBB.class);
        System.out.println(bbb);
    }
}
