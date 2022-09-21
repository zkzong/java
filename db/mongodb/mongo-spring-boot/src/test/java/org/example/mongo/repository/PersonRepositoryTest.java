package org.example.mongo.repository;

import org.example.mongo.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void before() {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setUserName("name" + i);
            person.setAge(i);
            personRepository.save(person);
        }
    }

    @Test
    public void all() {
        List<Person> personList = personRepository.findAll();
        System.out.println(personList);
    }

    @Test
    public void page() {
        Page<Person> page = personRepository.findAll(new PageRequest(0, 10));
        for (Person person : page) {
            System.out.println(person);
        }
    }

}