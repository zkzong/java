package com.zkzong.sb.redis.service.impl;

import com.zkzong.sb.redis.domain.User;
import com.zkzong.sb.redis.mapper.UserMapper;
import com.zkzong.sb.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/*@Autowired
	private JedisCluster jedisCluster;*/


	@Override
	@Cacheable(value = "allUser")
	public List<User> findAllUser() {
		System.out.println("测试缓存，第二次查询不走方法!!!");
		List<User> list = userMapper.findAll();
		return list;
	}


	@Override
	public Map<String, Object> redisMap() {
		return null;
	}


	//@Override
	//public Map<String, Object> redisMap() {
		//jedisCluster.set("user", "张三丰");
		//设置完毕，获取之
		//String value = jedisCluster.get("user");
		//Map<String, Object> maps = new HashMap<String, Object>();
		//maps.put("redis", value);
		//return maps;
	//}

}
