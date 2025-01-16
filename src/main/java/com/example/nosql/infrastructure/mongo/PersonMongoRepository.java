package com.example.nosql.infrastructure.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonMongoRepository extends MongoRepository<PersonDocument, String> {
}
