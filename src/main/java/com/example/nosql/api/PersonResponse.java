package com.example.nosql.api;

import com.example.nosql.application.Person;

public class PersonResponse {

    private final String id;
    private final String name;
    private final int age;

    private PersonResponse(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static PersonResponse from(Person person) {
        return new PersonResponse(person.getId(), person.getName(), person.getAge());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
