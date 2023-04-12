package ru.job4j.auth.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.auth.domain.Person;
import ru.job4j.auth.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimplePersonService {

    private final PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public boolean update(Person person) {
        if (personRepository.findById(person.getId()).isPresent()) {
            this.personRepository.save(person);
            return true;
        }
        return false;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(int id) {
        return personRepository.findById(id);
    }

    @Transactional
    public boolean delete(int id) {
        if (personRepository.findById(id).isPresent()) {
            Person person = new Person();
            person.setId(id);
            this.personRepository.delete(person);
            return true;
        }
         return false;
    }

}
