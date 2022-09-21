package org.example.sb.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.example.sb.mybatis.mapper")
public class One2ManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(One2ManyApplication.class, args);
	}
}
