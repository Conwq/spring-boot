package com.example.taskforreview.facade;

import com.example.taskforreview.dto.PersonDTO;
import com.example.taskforreview.entity.Person;
import com.example.taskforreview.service.PersonService;
import com.example.taskforreview.util.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonFacade {

    private final PersonService personService;

    @Autowired
    public PersonFacade(PersonService personService) {
        this.personService = personService;
    }

    public List<PersonDTO> getPersons() {
        List<Person> personList = personService.getPersons();
        List<PersonDTO> personDTOList = new ArrayList<>();
        for (Person person : personList) {
            personDTOList.add(PersonMapper.fromPersonDTO(person));
        }
        return personDTOList;
    }

    public PersonDTO getPerson(int id) {
        Person person = personService.getPerson(id);
        return PersonMapper.fromPersonDTO(person);
    }

    public void deletePerson(int id) {
        personService.deletePerson(id);
    }

    public void addPerson(PersonDTO personDTO) {
        Person person = PersonMapper.fromPerson(personDTO);
        personService.addPerson(person);
    }

    public void updatePerson(PersonDTO personDTO) {
        Person person = PersonMapper.fromPerson(personDTO);
        personService.updatePerson(person);
    }
}
