package org.example.service.impl;

import org.example.service.RedisTestService;
import org.springframework.stereotype.Service;

@Service
public class RedisTestServiceImpl implements RedisTestService {

	@Override
	public String getTimestamp(String param) {
		Long timestamp = System.currentTimeMillis();
		return timestamp.toString();
	}

}
