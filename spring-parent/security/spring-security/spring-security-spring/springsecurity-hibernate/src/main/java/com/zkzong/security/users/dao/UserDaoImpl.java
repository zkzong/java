package com.zkzong.security.users.dao;

import com.zkzong.security.users.model.Users;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public Users findByUserName(String username) {

        List<Users> users = new ArrayList<Users>();

        users = getSessionFactory().getCurrentSession().createQuery("from Users where username=?")
                .setParameter(0, username).list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}