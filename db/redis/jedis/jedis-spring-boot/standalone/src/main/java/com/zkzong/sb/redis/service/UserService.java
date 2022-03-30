package com.zkzong.sb.redis.service;

import com.zkzong.sb.redis.domain.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 根据接口查询所用的用户
     */
    List<User> findAllUser();

    Map<String, Object> redisMap();

    @Cacheable(value = "cache:customer", unless = "null == #result", key = "#id")
    User cacheOne(Integer id);

    @Cacheable(value = "cache:customer", unless = "null == #result", key = "#id")
    User cacheOne2(Integer id);

    // todo 自定义redis缓存的key,
    @Cacheable(value = "cache:customer", unless = "null == #result", key = "#root.methodName + '.' + #id")
    User cacheOne3(Integer id);

    // todo 这里缓存到redis，还有响应页面是String（加了很多转义符\,），不是Json格式
    @Cacheable(value = "cache:customer", unless = "null == #result", key = "#root.methodName + '.' + #id")
    User cacheOne4(Integer id);

    // todo 缓存json，不乱码已处理好,调整序列化和反序列化
    @Cacheable(value = "cache:customer", unless = "null == #result", key = "#root.methodName + '.' + #id")
    User cacheOne5(Integer id);

    // ==================================删除缓存
    @CacheEvict(value = "cache:customer", key = "'cacheOne5' + '.' + #id")
    Object del(Integer id);

    @CacheEvict(value = "cache:customer", allEntries = true)
    void del();

    @Cacheable(value = "cache:all")
    List<User> cacheList();

    // todo 先查询缓存，再校验是否一致，然后更新操作，比较实用，要清楚缓存的数据格式（明确业务和缓存模型数据）
    @CachePut(value = "cache:all", unless = "null == #result", key = "#root.methodName")
    List<User> cacheList2();
}
