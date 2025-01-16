package com.example.nosql.api;

import com.example.nosql.application.Person;
import com.example.nosql.application.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> get(@PathVariable String id) {
        Person person = repository.findById(id);
        return ResponseEntity
                .ok(PersonResponse.from(person));
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody PersonCreateRequest request) {
        repository.save(request.toModel());
        return ResponseEntity
                .created(URI.create("localhost:8080"))
                .build();
    }

}
