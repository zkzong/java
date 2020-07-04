package com.zkzong.security.users.dao;

import com.zkzong.security.users.model.Users;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Users findByUserName(String username) {

		List<Users> users = new ArrayList<Users>();

		users = sessionFactory.getCurrentSession().createQuery("from Users where username=?").setParameter(0, username)
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}