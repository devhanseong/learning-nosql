package com.example.nosql.application;

public class Person {

    private final String id;
    private final String name;
    private final int age;

    private Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static Person of(String id, String name, int age) {
        return new Person(id, name, age);
    }

    public static Person of(String name, int age) {
        return of(null, name, age);
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
