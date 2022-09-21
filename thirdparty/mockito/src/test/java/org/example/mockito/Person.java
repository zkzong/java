package org.example.mockito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String key;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String setKeyById(int id) {
        this.key = id + this.name + id;
        return this.key;
    }
}
