package io.github.rdx7777.jugtours;

import io.github.rdx7777.jugtours.model.Event;
import io.github.rdx7777.jugtours.model.Group;
import io.github.rdx7777.jugtours.repository.GroupRepository;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Newcastle JUG", "Glasgow JUG", "Manchester JUG", "London JUG")
            .forEach(name -> repository.save(new Group(name))
            );

        Group djug = repository.findByName("Newcastle JUG");
        Event event = Event.builder()
            .title("Full Stack Reactive")
            .description("Reactive with Spring Boot + React")
            .date(Instant.parse("2020-08-31T17:00:00Z"))
            .build();
        djug.setEvents(Collections.singleton(event));
        repository.save(djug);
    }
}
