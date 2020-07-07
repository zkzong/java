package com.zkzong.jmeter;

import com.zkzong.dubbo.web.entity.User;
import com.zkzong.dubbo.web.facade.UserFacade;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserFacadeTest {
    @Autowired
    private UserFacade userFacade;

    @Before
    public void setupTest() {
        DubboInit init = DubboInit.getInstance();
        init.initApplicationContext();
        userFacade = (UserFacade) init.getBean("userFacade");
    }

    @Test
    public void queryUser() throws Exception {
        User user = userFacade.queryUser();
        System.out.println(user);
    }

}