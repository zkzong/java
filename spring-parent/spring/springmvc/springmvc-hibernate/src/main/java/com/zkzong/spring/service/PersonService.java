package com.zkzong.spring.service;

import com.zkzong.spring.model.Person;

import java.util.List;

/**
 * Created by zong on 2017/3/2.
 */
public interface PersonService {
    void addPerson(Person p);

    void updatePerson(Person p);

    List<Person> listPersons();

    Person getPersonById(int id);

    void removePerson(int id);
}
