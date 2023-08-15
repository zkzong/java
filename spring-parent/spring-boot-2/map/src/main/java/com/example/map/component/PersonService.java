package com.example.map.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    @Autowired
    List<IPerson> persons;

    @Autowired
    Map<String, IPerson> personMaps;

    public void echo() {
        System.out.println("print list:");
        for (IPerson p : persons) {
            p.doWork();
        }

        System.out.println("\nprint map:");
        for (Map.Entry entry : personMaps.entrySet()) {
            System.out.println("Person:" + entry.getKey() + ", " + entry.getValue());
        }
    }
}
