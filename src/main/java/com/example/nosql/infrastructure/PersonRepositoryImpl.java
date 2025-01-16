package com.example.nosql.infrastructure;

import com.example.nosql.application.Person;
import com.example.nosql.application.PersonRepository;
import com.example.nosql.infrastructure.mongo.PersonDocument;
import com.example.nosql.infrastructure.mongo.PersonMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final PersonMongoRepository repository;

    public PersonRepositoryImpl(PersonMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person findById(String id) {
        PersonDocument document = repository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException();
                });
        return document.toModel();
    }

    @Override
    public void save(Person person) {
        repository.save(PersonDocument.from(person));
    }
}
