package com.zkzong.spring.dao;

import com.zkzong.spring.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zong on 2017/3/2.
 */
public class PersonDaoImpl implements PersonDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPerson(Person p) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(p);
        LOGGER.info("Person saved successfully, Person Details=" + p);
    }

    @Override
    public void updatePerson(Person p) {
        Session session = sessionFactory.getCurrentSession();
        session.update(p);
        LOGGER.info("Person updated successfully, Person Details=" + p);
    }

    @Override
    public List<Person> listPersons() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> personList = session.createQuery("from Person").list();
        for (Person p : personList) {
            LOGGER.info("Person List : " + p);
        }
        return personList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, Integer.valueOf(id));
        LOGGER.info("Person loaded successfully, Person Details=" + p);
        return p;
    }

    @Override
    public void removePerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, Integer.valueOf(id));
        if (p != null) {
            session.delete(p);
        }
        LOGGER.info("Person deleted successfully, Person Details=" + p);
    }
}
