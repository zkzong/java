package com.zkzong.spring.service;

import com.zkzong.spring.dao.PersonDao;
import com.zkzong.spring.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zong on 2017/3/2.
 */
@Service
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public void addPerson(Person p) {
        personDao.addPerson(p);
    }

    @Override
    @Transactional
    public void updatePerson(Person p) {
        personDao.updatePerson(p);
    }

    @Override
    @Transactional
    public List<Person> listPersons() {
        return personDao.listPersons();
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return personDao.getPersonById(id);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        personDao.removePerson(id);
    }
}
