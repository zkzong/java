package com.zkzong.retry;

import com.zkzong.retry.pojo.User;
import com.zkzong.retry.service.RemoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRetryApplicationTests {

	@Autowired
	private RemoteService remoteService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void call() {
		User user = new User("zong", 30);
		remoteService.call(user);
	}

}
