package ru.job4j.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.job4j.auth.domain.Person;

import java.util.List;

@Component
public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findAll();

    public Person findByLogin(String login);

}