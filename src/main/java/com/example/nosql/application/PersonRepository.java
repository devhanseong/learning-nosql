package com.example.nosql.application;

public interface PersonRepository {

    Person findById(String id);

    void save(Person person);
}
