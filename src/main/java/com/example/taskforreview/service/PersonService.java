package com.example.taskforreview.service;

import com.example.taskforreview.entity.Person;
import com.example.taskforreview.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPerson(int id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty())
            throw new IllegalStateException("Person with id " + id + " not found");
        return optionalPerson.get();
    }

    public void deletePerson(int id) {
        boolean exist = personRepository.existsById(id);
        if (!exist)
            throw new IllegalStateException("Person with id " + id + " not delete because hi not found");
        personRepository.deleteById(id);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void updatePerson(Person person) {
        Optional<Person> optionalPerson = personRepository.findById(person.getId());
        if (optionalPerson.isEmpty())
            throw new IllegalStateException("Person for update with id " + person.getId() + " not found");
        Person updatePerson = optionalPerson.get();
        if (person.getName() != null && person.getName().length() > 0)
            updatePerson.setName(person.getName());
        if (person.getAge() > 0)
            updatePerson.setAge(person.getAge());
    }
}
