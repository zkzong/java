package com.example.retry;

import com.example.retry.pojo.User;
import com.example.retry.service.RemoteService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class SpringRetryApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringRetryApplication.class, args);
		ApplicationContext annotationContext = new AnnotationConfigApplicationContext(SpringRetryApplication.class);
		RemoteService remoteService = annotationContext.getBean(RemoteService.class);
		User user = new User("zong", 30);
		remoteService.call(user);
	}
}
