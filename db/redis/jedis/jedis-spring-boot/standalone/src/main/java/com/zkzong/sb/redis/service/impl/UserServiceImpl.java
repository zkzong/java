package com.zkzong.sb.redis.service.impl;

import com.zkzong.sb.redis.domain.User;
import com.zkzong.sb.redis.mapper.UserMapper;
import com.zkzong.sb.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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

    @Override
    @Cacheable(value = "cache:customer", unless = "null == #result", key = "#id")
    public User cacheOne(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    @Override
    @Cacheable(value = "cache:customer", unless = "null == #result", key = "#id")
    public User cacheOne2(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    // todo 自定义redis缓存的key,
    @Override
    @Cacheable(value = "cache:customer", unless = "null == #result", key = "#root.methodName + '.' + #id")
    public User cacheOne3(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    // todo 这里缓存到redis，还有响应页面是String（加了很多转义符\,），不是Json格式
    @Override
    @Cacheable(value = "cache:customer", unless = "null == #result", key = "#root.methodName + '.' + #id")
    public User cacheOne4(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    // todo 缓存json，不乱码已处理好,调整序列化和反序列化
    @Override
    @Cacheable(value = "cache:customer", unless = "null == #result", key = "#root.methodName + '.' + #id")
    public User cacheOne5(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }


    // ==================================删除缓存
    @Override
    @CacheEvict(value = "cache:customer", key = "'cacheOne5' + '.' + #id")
    public Object del(Integer id) {
        // 删除缓存后的逻辑
        return null;
    }

    @Override
    @CacheEvict(value = "cache:customer", allEntries = true)
    public void del() {

    }

    @CacheEvict(value = "cache:all", allEntries = true)
    public void delall() {

    }
    // ==================List操作

    @Override
    @Cacheable(value = "cache:all")
    public List<User> cacheList() {
        List<User> all = userMapper.findAll();
        return all;
    }

    // todo 先查询缓存，再校验是否一致，然后更新操作，比较实用，要清楚缓存的数据格式（明确业务和缓存模型数据）
    @Override
    @CachePut(value = "cache:all", unless = "null == #result", key = "#root.methodName")
    public List<User> cacheList2() {
        List<User> all = userMapper.findAll();
        return all;
    }

}
