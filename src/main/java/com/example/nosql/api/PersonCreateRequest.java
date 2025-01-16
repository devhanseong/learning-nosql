package com.example.nosql.api;

import com.example.nosql.application.Person;

public class PersonCreateRequest {

    private final String name;
    private final int age;

    private PersonCreateRequest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person toModel() {
        return Person.of(name, age);
    }
}
