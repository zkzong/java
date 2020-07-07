package com.zkzong.dubbo.service;

import java.util.Collection;

/**
 * {@link User} Service.
 */
public interface UserService {

    boolean save(User user);

    boolean remove(Long userId);

    Collection<User> findAll();
}
