package com.example.nosql.infrastructure.mongo;

import com.example.nosql.application.Person;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persons")
public class PersonDocument {

    @Id
    private String id;

    private String name;

    private int age;

    public PersonDocument() {
    }

    private PersonDocument(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static PersonDocument from(Person person) {
        return new PersonDocument(person.getId(), person.getAge());
    }

    public Person toModel() {
        return Person.of(id, name, age);
    }
}
