package com.example.taskforreview.util;

import com.example.taskforreview.dto.PersonDTO;
import com.example.taskforreview.entity.Person;

public class PersonMapper {

    public static PersonDTO fromPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setAge(person.getAge());
        personDTO.setName(person.getName());
        personDTO.setBooks(person.getBooks());
        return personDTO;
    }

    public static Person fromPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setAge(personDTO.getAge());
        person.setName(personDTO.getName());
        person.setBooks(personDTO.getBooks());
        return person;
    }
}
